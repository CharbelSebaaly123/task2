# GitHub Guide: Repo Setup, Local Clone, and Raising a PR

This guide teaches you three things in order:
1. Create a GitHub repository
2. Clone it to your local machine
3. Raise a Pull Request — two ways: from the command line, and from the GitHub website

Save this file. Share it with teammates who are new to Git.

---

## Prerequisites

- A free GitHub account (sign up at [github.com](https://github.com))
- Git installed locally — verify with `git --version` in your terminal
- (Optional) GitHub CLI installed — `gh --version`; install from [cli.github.com](https://cli.github.com)

---

## Part 1: Create a GitHub Repository

### On the GitHub website

1. Log in to [github.com](https://github.com)
2. Click the **+** icon (top-right) → **New repository**
3. Fill in the form:
   - **Repository name:** `code-review-agentic-era` (or any name you like)
   - **Description:** `Intern learning path — Task 4 hands-on exercise`
   - **Visibility:** Public (so CodeRabbit's free tier can access it)
   - ✅ Check **Add a README file**
   - (Optional) Add a `.gitignore` → choose **Java**
4. Click **Create repository**

You now have a remote repository at `https://github.com/<your-username>/code-review-agentic-era`

---

## Part 2: Clone the Repository Locally

Cloning downloads the repository to your computer so you can edit files.

Open a terminal and run:

```bash
# Replace <your-username> with your actual GitHub username
git clone https://github.com/<your-username>/code-review-agentic-era.git

# Move into the project folder
cd code-review-agentic-era
```

**What just happened?**
- Git created a folder named `code-review-agentic-era` on your machine
- It downloaded all files from GitHub into that folder
- It set up a remote called `origin` pointing back to GitHub

Verify with:
```bash
git remote -v
# Should print two lines starting with "origin"
```

---

## Part 3A: Raise a PR from Your Local Machine (Command Line)

This is the standard professional workflow. Every step is a Git command.

### Step 1 — Create a feature branch

Never commit directly to `main`. Always work on a branch.

```bash
# Create and switch to a new branch in one command
git checkout -b feature/add-buggy-calculator
```

The branch name follows the convention `type/description`. Common prefixes: `feature/`, `fix/`, `chore/`.

### Step 2 — Add your file(s)

Copy `BuggyCalculator.java` (from this project folder) into your cloned repo folder, then:

```bash
# See what changed
git status

# Stage the file (tell Git to include it in the next commit)
git add BuggyCalculator.java

# Confirm it is staged
git status
# Should show: "Changes to be committed: new file: BuggyCalculator.java"
```

### Step 3 — Commit

A commit is a saved snapshot. Write a clear message.

```bash
git commit -m "Add BuggyCalculator with intentional review issues"
```

**Commit message conventions:**
- Use the imperative mood: "Add X", "Fix Y", "Remove Z" (not "Added" or "Adding")
- Keep the first line under 72 characters
- Optionally add a blank line, then a longer explanation below

### Step 4 — Push the branch to GitHub

```bash
git push origin feature/add-buggy-calculator
```

This uploads your branch to GitHub. `origin` is the shorthand for your GitHub remote.

### Step 5 — Open the Pull Request

**Option A — GitHub CLI (fastest):**
```bash
gh pr create \
  --title "Add BuggyCalculator for AI reviewer testing" \
  --body "This PR adds a Java class with intentional code issues to test CodeRabbit's review capabilities. See task2_spec_plan.md for context." \
  --base main \
  --head feature/add-buggy-calculator
```

**Option B — browser prompt:**
After you push, GitHub prints a URL in the terminal:
```
remote: Create a pull request for 'feature/add-buggy-calculator' on GitHub by visiting:
remote:      https://github.com/<your-username>/code-review-agentic-era/pull/new/feature/add-buggy-calculator
```
Open that URL → fill in the title and description → click **Create pull request**.

### Step 6 — What happens next

- GitHub creates the PR
- Reviewers (human or AI like CodeRabbit) can comment on specific lines
- You can push more commits to the same branch — the PR updates automatically
- When approved, someone clicks **Merge pull request**

---

## Part 3B: Raise a PR from the GitHub Website (No Terminal)

Use this when you want to make a quick edit directly in the browser, or when you don't have Git set up locally.

### Step 1 — Navigate to the file you want to edit

Go to your repository at `https://github.com/<your-username>/code-review-agentic-era`

### Step 2 — Upload or create the file

**To upload a file:**
1. Click **Add file** → **Upload files**
2. Drag `BuggyCalculator.java` onto the page (or click to browse)
3. Scroll down to **Commit changes**

**To create a file directly:**
1. Click **Add file** → **Create new file**
2. Type the filename (e.g. `BuggyCalculator.java`)
3. Paste the file contents into the editor

### Step 3 — Commit to a new branch (not main)

In the **Commit changes** section at the bottom:
1. Write a commit message: `Add BuggyCalculator with intentional review issues`
2. Select **Create a new branch for this commit and start a pull request**
3. Name the branch: `feature/add-buggy-calculator`
4. Click **Propose changes**

### Step 4 — Fill in the PR form

GitHub takes you straight to the **Open a pull request** form:
1. **Title:** `Add BuggyCalculator for AI reviewer testing`
2. **Description:** Explain what the PR does and why (link to the task spec)
3. Click **Create pull request**

That's it — the PR is open and reviewers can comment.

---

## Part 4: The Diff Explained

When a PR is open, GitHub shows a **diff** — the exact lines that changed:

```diff
+ public double divide(double a, double b) {
+     return a / b;  // BUG: no zero check
+ }
```

- Lines prefixed with `+` (green) were **added**
- Lines prefixed with `-` (red) were **removed**
- Lines with no prefix (white) are unchanged context

Click any line number to leave an inline comment. This is where reviewers write their feedback.

---

## Part 5: Updating a PR After Review

If a reviewer requests changes:

```bash
# Make the fix locally
# Then stage and commit
git add BuggyCalculator.java
git commit -m "Fix: add zero check in divide()"

# Push again to the same branch — the PR updates automatically
git push origin feature/add-buggy-calculator
```

The PR thread shows the new commit. The reviewer can re-review and approve.

---

## Quick Reference Cheatsheet

| Action | Command |
|--------|---------|
| Clone a repo | `git clone <url>` |
| Create a branch | `git checkout -b <branch-name>` |
| See changes | `git status` |
| Stage a file | `git add <file>` |
| Stage everything | `git add .` |
| Commit | `git commit -m "message"` |
| Push branch | `git push origin <branch-name>` |
| Open PR (CLI) | `gh pr create` |
| Pull latest main | `git checkout main && git pull` |

---

## Glossary

**Repository (repo):** The folder that Git tracks. Contains all files and the full history of changes.

**Clone:** Download a remote repository to your local machine.

**Branch:** An isolated line of development. Changes on a branch don't affect `main` until merged.

**Commit:** A saved snapshot of staged changes. Has a message describing what changed and why.

**Push:** Upload your local commits to the remote (GitHub).

**Pull Request (PR):** A request to merge your branch into another (usually `main`). The place where code review happens.

**Diff:** The exact lines that were added or removed in a PR.

**Merge:** Combining a branch's changes into the target branch after review is complete.

---

*This guide is part of the intern learning path. See `task2_spec_plan.md` for the full task breakdown.*
