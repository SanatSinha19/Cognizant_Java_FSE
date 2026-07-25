# Git-HOL 1 — Git Configuration & First Commit

## Objective
Set up Git configuration, initialize a repository, and make a first commit.

## Commands Run & Output

​```
git config --global user.name "SanatSinha19"
git config --global user.email "itssanat196@gmail.com"
git config --global core.editor "code --wait"

git config --list
user.name=SanatSinha19
user.email=itssanat196@gmail.com
core.editor=code --wait
​```

​```
mkdir git-practice
cd git-practice
git init
Initialized empty Git repository in C:/Users/KIIT0001/Desktop/git-practice/.git/
​```

​```
echo Welcome to Git practice > welcome.txt
git status
On branch master
No commits yet
Untracked files:
        welcome.txt

git add welcome.txt
git commit -m "Add welcome.txt"
[master (root-commit) 63461d5] Add welcome.txt
 1 file changed, 1 insertion(+)
 create mode 100644 welcome.txt

git status
On branch master
nothing to commit, working tree clean
​```

## What I Learned
- `git init` creates a hidden `.git` folder that turns a normal folder into a Git repository.
- `git status` shows the current state of the working directory vs. the staging area vs. the last commit.
- Files must be explicitly `git add`-ed (staged) before they can be `git commit`-ed.
- Git config is set globally (`--global`) so identity persists across all repos on the machine.