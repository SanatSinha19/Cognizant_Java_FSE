# Git-HOL 4 — Merge Conflict Resolution

## Objective
Deliberately create a merge conflict (same file, different content, on 
two branches) and resolve it.

## Commands Run & Output

​```
git checkout master
git branch GitWork
git checkout GitWork
Switched to branch 'GitWork'

echo <message>Hello from GitWork</message> > hello.xml
echo <message>Updated content on GitWork branch</message> > hello.xml

git status
Untracked files:
        hello.xml

git add hello.xml
git commit -m "Add hello.xml with GitWork content"
[GitWork 3ea56aa] Add hello.xml with GitWork content
​```

​```
git checkout master
Switched to branch 'master'
dir
​```
hello.xml is absent here — confirms master has no knowledge of GitWork's file yet.

​```
echo <message>Hello from master branch</message> > hello.xml
git add hello.xml
git commit -m "Add hello.xml with master content"
[master f245015] Add hello.xml with master content
​```

​```
git log --oneline --graph --decorate --all
* f245015 (HEAD -> master) Add hello.xml with master content
| * 3ea56aa (GitWork) Add hello.xml with GitWork content
|/
* 8710c50 Add branch-file.txt on GitNewBranch
* 254895d Add .gitignore to exclude log files and log folder
* 63461d5 Add welcome.txt
​```
History shows two commits diverging from the same base — both branches 
independently added hello.xml with different content.

​```
git diff master GitWork
-<message>Hello from master branch</message>
+<message>Updated content on GitWork branch</message>
​```

​```
git merge GitWork
Auto-merging hello.xml
CONFLICT (add/add): Merge conflict in hello.xml
Automatic merge failed; fix conflicts and then commit the result.
​```

​```
type hello.xml
<<<<<<< HEAD
<message>Hello from master branch</message>
=======
<message>Updated content on GitWork branch</message>
>>>>>>> GitWork
​```
Git inserted conflict markers directly into the file since both branches 
added the same file independently (an "add/add" conflict) with no common 
ancestor version to auto-merge against.

## Resolving the Conflict
Opened hello.xml in VS Code. VS Code detected the conflict markers and 
displayed inline actions above the conflict block: "Accept Current 
Change", "Accept Incoming Change", "Accept Both Changes", "Compare 
Changes". Selected "Accept Both Changes", which combined both messages 
and automatically removed the <<<<<<<, =======, >>>>>>> markers:

​```xml
<message>Hello from master branch</message>
<message>Updated content on GitWork branch</message>
​```

​```
git add hello.xml
git commit -m "Resolve merge conflict in hello.xml"
[master 6a784f1] Resolve merge conflict in hello.xml

git status
On branch master
nothing to commit, working tree clean
​```

​```
echo *.orig >> .gitignore
git add .gitignore
git commit -m "Ignore .orig backup files created during merge conflict resolution"
[master b23d001] Ignore .orig backup files created during merge conflict resolution
​```

​```
git branch
  GitWork
* master

git branch -d GitWork
Deleted branch GitWork (was 3ea56aa).
​```

​```
git log --oneline --graph --decorate
* b23d001 (HEAD -> master) Ignore .orig backup files created during merge conflict resolution
*   6a784f1 Resolve merge conflict in hello.xml
|\
| * 3ea56aa Add hello.xml with GitWork content
* | f245015 Add hello.xml with master content
|/
* 8710c50 Add branch-file.txt on GitNewBranch
* 254895d Add .gitignore to exclude log files and log folder
* 63461d5 Add welcome.txt
​```
Note the two parent lines (|\ and |/) converging at commit 6a784f1 — 
this is a genuine merge commit, unlike Git-HOL 3's fast-forward merge 
which had no divergent history to reconcile.

## What I Learned
- A merge conflict occurs when Git cannot automatically reconcile 
  changes — here, an "add/add" conflict, since both branches created 
  the same file independently with different content.
- Git marks conflicts directly inside the file using <<<<<<<, =======, 
  and >>>>>>> markers, showing "our" version (HEAD) vs. the "incoming" 
  version (the branch being merged).
- Unlike a fast-forward merge, resolving a real conflict produces a 
  dedicated merge commit with two parent commits — visible in the log 
  graph as two lines converging.
- VS Code's built-in merge conflict UI makes resolution much easier than 
  manually editing conflict markers — it auto-removes the markers once 
  a resolution choice is made.
- After resolving, the conflicted file must still be explicitly 
  `git add`-ed and committed to complete the merge.