# Code Review in the Agentic Era — Intern Learning Path

**Author:** Charbel Sebaaly  
**Project:** Task 2 — Where the "Agentic Era" Problem Came From  
**Duration:** 4–5 working days

---

## What This Project Is

This repository is the hands-on component of an intern learning path exploring why code review became a bottleneck once AI agents started writing code at scale. The goal is not to build a production system — it is to understand the problem and form an opinion about the solutions.

---

## Repository Structure

```
├── README.md                  ← You are here
├── .gitignore                 ← Excludes Java build artifacts
├── docs/
│   ├── task2_spec_plan.md     ← Full spec-driven plan for all 6 tasks
│   └── github_guide.md        ← How to create a repo, clone, and raise a PR
└── src/
    └── BuggyCalculator.java   ← Java file used for Task 4 (intentional bugs)
```

---

## Quick Start

### For Task 4 (hands-on exercise)

1. Read `docs/task2_spec_plan.md` to understand the full task breakdown
2. Open `src/BuggyCalculator.java` — it contains 7 intentional code issues
3. Follow `docs/github_guide.md` to push it to GitHub and open a PR
4. Connect [CodeRabbit](https://coderabbit.ai) (free tier) to your repo and watch it review the PR
5. Screenshot the AI's comments and note what it caught, missed, and got wrong

### For Tasks 2 and 5 (written deliverables)

These are the highest-weighted tasks. See `docs/task2_spec_plan.md` for the exact spec and acceptance criteria.

---

## Intentional Bugs in BuggyCalculator.java

These are planted on purpose for the AI reviewer exercise:

| # | Location | Issue |
|---|----------|-------|
| 1 | `divide()` | No check for zero divisor — returns `Infinity` silently |
| 2 | `processInput()` | No null check — throws `NullPointerException` |
| 3 | `processInput()` | Empty catch block — exception is swallowed |
| 4 | `isTaxMode()` | `==` used for String comparison instead of `.equals()` |
| 5 | `isTaxMode()` | Single-letter variable `m` — meaningless name |
| 6 | Class fields | Magic numbers `x = 100` and `y = 0.15` — undocumented |
| 7 | Entire class | Zero unit tests |

---

## Learning Path Overview

| Task | Topic | Weight |
|------|-------|--------|
| 0 | What is code review? | Warm-up |
| 1 | Why review exists | Foundation |
| **2** | **Why the agentic era created the bottleneck** | **⭐ Highest** |
| 3 | Survey of existing solutions | Research |
| 4 | Hands-on with an AI reviewer | Practical |
| **5** | **Critical thinking** | **⭐ Highest** |
| 6 | Mini-presentation (optional) | Stretch |

---

## How to Connect to GitHub (after creating your repo)

```bash
# Run these commands from inside this project folder
git init
git add .
git commit -m "Initial commit: spec plan, Java demo, and guides"
git branch -M main
git remote add origin https://github.com/<your-username>/<your-repo-name>.git
git push -u origin main
```

Then follow `docs/github_guide.md` to create your feature branch and PR.
# task2
# task2
