# Git-HOL 2 — .gitignore

## Objective
Ignore `.log` files and a `log` folder from being tracked by Git.

## Commands Run & Output

​```
echo This is a log file > app.log
mkdir log
echo Inside log folder > log\debug.log

git status
On branch master
Untracked files:
        app.log
        log/
​```

​```
echo *.log > .gitignore
echo log/ >> .gitignore

type .gitignore
*.log
log/
​```

​```
git status
On branch master
Untracked files:
        .gitignore
​```
Note: app.log and log/ no longer appear as untracked — .gitignore is 
correctly excluding them, even though the files still physically exist.

​```
git add .gitignore
git commit -m "Add .gitignore to exclude log files and log folder"
[master 254895d] Add .gitignore to exclude log files and log folder
 1 file changed, 2 insertions(+)
 create mode 100644 .gitignore

git status
On branch master
nothing to commit, working tree clean
​```

## What I Learned
- `.gitignore` prevents specified files/folders from ever appearing as 
  "untracked" in `git status` — Git simply skips over them entirely.
- Ignored files still exist on disk; Git just doesn't track or offer to 
  commit them.
- Wildcard patterns like `*.log` match any file with that extension, 
  while `log/` matches the entire folder and everything inside it.
- `.gitignore` itself is a normal file that should be committed to the 
  repo, so the ignore rules apply consistently for anyone who clones it.