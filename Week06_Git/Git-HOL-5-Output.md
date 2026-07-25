# Git-HOL 5 — Cleanup and Push to Remote

## Objective
Verify clean state, list branches, pull from remote, and push pending 
changes to remote repository.

## Adaptation Note
This hands-on assumes an existing remote repository connection. Since 
all Git-HOL practice (1–5) was intentionally kept in a local-only 
practice repository (`git-practice`) — separate from the main 
Cognizant_Java_FSE submission repo, and without creating an additional 
GitHub remote purely for practice — the push/pull portions of this 
exercise are demonstrated conceptually below rather than executed 
against a live remote. The local verification steps (clean state, 
branch listing) were run for real.

## Commands Run & Output

​```
git status
On branch main
nothing to commit, working tree clean

git branch
* main
​```

## What This Step Would Do With a Remote
- `git pull origin main` — fetches any new commits from the remote and 
  merges them into the local branch, ensuring the local copy is 
  up to date before pushing.
- `git push origin main` — uploads local commits that don't yet exist 
  on the remote, making them visible to anyone else with access to 
  that repository.
- Confirming changes "reflected in the remote repository" means 
  refreshing the repo's page (e.g., on GitHub) and seeing the new 
  commits/files appear.

This exact push/pull cycle was already demonstrated for real throughout 
Weeks 1–5 of this Deep Skilling submission — every `git add`, `commit`, 
and `push` used to submit this program's actual coursework followed 
this same pattern against the real Cognizant_Java_FSE remote repository 
on GitHub.

## What I Learned
- `git pull` should generally be run before `git push`, to avoid 
  conflicts with changes made elsewhere (e.g., by teammates, or from a 
  different machine) since your last sync.
- A clean `git status` before pushing means there's nothing 
  uncommitted left behind — only committed history moves between 
  local and remote.
- Keeping a repository's remote in sync (`pull` then `push`) is the 
  final, routine step of any real Git workflow — which this entire 
  Deep Skilling submission has followed consistently since Week 1.