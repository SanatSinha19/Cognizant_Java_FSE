# Git-HOL 3 — Branching and Merging

## Objective
Create a branch, make changes, commit, merge back to master, and view 
commit history as a graph.

## Commands Run & Output

​```
git branch GitNewBranch

git branch
  GitNewBranch
* master
​```
The * marks the currently active branch (master), even after 
GitNewBranch is created — creating a branch does not switch to it.

​```
git checkout GitNewBranch
Switched to branch 'GitNewBranch'
​```

​```
echo This file was created on GitNewBranch > branch-file.txt
git add branch-file.txt
git commit -m "Add branch-file.txt on GitNewBranch"
[GitNewBranch 8710c50] Add branch-file.txt on GitNewBranch
 1 file changed, 1 insertion(+)
 create mode 100644 branch-file.txt
​```

​```
git checkout master
Switched to branch 'master'

dir
​```
branch-file.txt is absent from this listing — it only exists on 
GitNewBranch, proving each branch maintains an independent file state.

​```
git diff master GitNewBranch
diff --git a/branch-file.txt b/branch-file.txt
new file mode 100644
+This file was created on GitNewBranch
​```

​```
git merge GitNewBranch
Updating 254895d..8710c50
Fast-forward
 branch-file.txt | 1 +
 1 file changed, 1 insertion(+)
 create mode 100644 branch-file.txt
​```
Fast-forward merge: since master had no new commits since branching, 
Git simply moved master's pointer forward to GitNewBranch's latest 
commit — no merge commit was needed.

​```
git log --oneline --graph --decorate
* 8710c50 (HEAD -> master, GitNewBranch) Add branch-file.txt on GitNewBranch
* 254895d Add .gitignore to exclude log files and log folder
* 63461d5 Add welcome.txt
​```
Both master and GitNewBranch now point to the same commit.

​```
git branch -d GitNewBranch
Deleted branch GitNewBranch (was 8710c50).

git status
On branch master
nothing to commit, working tree clean

git branch
* master
​```

## What I Learned
- Creating a branch (`git branch <name>`) does not switch to it — you 
  must explicitly `git checkout`/`git switch` to move onto it.
- Each branch has its own independent working directory state — files 
  committed on one branch don't appear on another until merged.
- A "fast-forward" merge happens when the target branch has no divergent 
  commits — Git just moves the pointer forward rather than creating a 
  new merge commit.
- `git log --oneline --graph --decorate` visualizes commit history and 
  shows exactly which branches/HEAD point to which commits.
- Deleting a branch after merging (`git branch -d`) is safe cleanup — 
  Git even prevents deletion with `-d` if the branch has unmerged 
  changes, protecting against accidental data loss.