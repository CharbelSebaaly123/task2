# Spec-Driven Plan: Code Review in the Agentic Era
**Intern Learning Path — Charbel Sebaaly**
**Project:** Task 2 | **Duration:** 4–5 working days

---

## Overview

This plan translates the intern learning path PDF into a structured, spec-driven schedule. Each task has a clear goal, acceptance criteria, and a concrete deliverable. Complete them in order — each one builds context for the next.

---

## Task 0 — Warm-Up: What Even Is Code Review?

**Goal:** Understand the vocabulary before touching anything about AI.

**Spec / What you produce:**
- A short written answer (max half a page) covering:
  - What is code review and why do teams do it?
  - What is a pull request (PR)?
  - What is a diff?
  - What are the benefits of review? What are the costs or annoyances?

**Acceptance criteria:**
- Written in your own words (no copy-paste from docs)
- Diff and PR are defined correctly
- At least one cost or annoyance is identified

**How to explore:**
- Read GitHub's official docs on pull requests
- Open any popular open-source repo (e.g., `microsoft/vscode`) → "Pull requests" tab → open one → observe the green/red lines (the diff), reviewer comments, and discussion thread

---

## Task 1 — Why Review Exists

**Goal:** Understand that review is a quality tool, not bureaucracy.

**Spec / What you produce:**
- A two-column table:

| Can be checked automatically (rules) | Requires understanding broader context |
|---------------------------------------|----------------------------------------|
| Formatting / indentation              | Logic correctness                      |
| Unused imports                        | Architectural fit                      |
| Syntax errors                         | Security intent                        |
| Naming conventions (linters)          | Business logic correctness             |
| Test coverage %                       | Whether the feature is even needed     |

**Acceptance criteria:**
- At least 5 rows per column
- Each item is genuinely in the right column (defend your choices)

---

## Task 2 — Where the "Agentic Era" Problem Came From ⭐ (highest weight)

**Goal:** Explain the bottleneck simply enough that a non-technical friend understands it.

**Background (read this first):**
An AI coding agent (Claude Code, Cursor, Codex, OpenCode) can generate 1,000 lines of code in under 5 minutes. A human reviewer reads and understands code at roughly the same speed they always have — maybe 200–400 lines per hour with careful attention. The math creates a queue. That queue is the problem.

**Spec / What you produce:**
- A paragraph of 5–8 sentences that:
  1. Defines what an AI coding agent is (one sentence)
  2. States the speed asymmetry (generation vs. review)
  3. Explains what happens to the PR queue as a result
  4. Draws the conclusion: code review became the bottleneck, not coding

**Acceptance criteria:**
- No jargon unexplained
- A non-technical reader could follow it
- The cause-and-effect chain is explicit (not implied)

**Example opening (do not copy, just model the style):**
> "An AI coding agent is a tool that writes and modifies source code on its own, not just suggests edits…"

---

## Task 3 — Survey of Existing Ideas for Speeding It Up

**Goal:** Map the landscape of solutions into three categories.

**Categories:**
- **Category A — AI reviewer agents:** tools that review the PR on the human's behalf (CodeRabbit, Greptile, Qodo, GitHub Copilot Code Review, PR-Agent, Kodus)
- **Category B — Workflow / UI changes:** changing how PRs are structured or opened (Graphite / stacked PRs, cloud agents that open PRs themselves)
- **Category C — Deterministic layer:** rule-based checks, not AI (Semgrep, SonarQube, ESLint/Checkstyle linters)

**Spec / What you produce:**
- One row per tool:

| Tool | What it does (1 sentence) | Category | Why that category |
|------|--------------------------|----------|-------------------|
| CodeRabbit | AI agent that posts review comments on your PR automatically | A | Replaces the human reviewer with an AI |
| Graphite | Lets you split one big PR into a stack of small, linked PRs | B | Changes the workflow, not the review itself |
| Semgrep | Runs pattern-matching security rules on every commit | C | Deterministic rules, no AI needed |
| … | … | … | … |

**Key insight to capture:** These categories layer — you use all three together. There is no single best tool, there is a stack.

---

## Task 4 — Touch It With Your Hands

**Goal:** Experience the review loop concretely, not just read about it.

**Spec / What you produce:**
- A GitHub repository with a Java file containing intentional bugs (see `BuggyCalculator.java` in this project)
- A PR opened against that repo
- An AI reviewer (CodeRabbit free tier) connected to the repo
- 3–5 screenshots of the AI reviewer's comments
- A short note (~200 words) on:
  - What the tool caught
  - What it missed
  - What was noise (unnecessary or wrong comments)

**Setup steps:**
1. See `github_guide.md` in this folder for how to create the repo, clone it, and raise the PR
2. Go to [coderabbit.ai](https://coderabbit.ai) → sign in with GitHub → add your repo
3. Push `BuggyCalculator.java` to a feature branch → open the PR → wait ~2 minutes for CodeRabbit's review

**Acceptance criteria:**
- PR is real and visible on GitHub
- At least one bug was caught by the AI reviewer
- Note identifies at least one thing the tool missed or got wrong

---

## Task 5 — Think Critically (Most Important Task) ⭐

**Goal:** Form your own opinion. There is no single right answer.

**Spec / What you produce:**
- One page of reflections (~400–500 words) addressing all four questions:

1. **Responsibility:** If AI reviews code that another AI wrote, who is responsible when a bug reaches production? Where does the human stay in the loop?
2. **Signal vs. noise:** Is it better to get 50 comments from a bot (with useful ones buried) or 5 targeted ones? Justify your answer.
3. **Hard limits:** Are there things AI review should never do autonomously? Which ones and why?
4. **The moving line:** Go back to your Task 1 table. Does AI move the boundary between "automatically checkable" and "requires context"? In which direction?

**Acceptance criteria:**
- All four questions answered
- At least one answer admits uncertainty ("I don't know, but I suspect…")
- No answer is just a restatement of the question

---

## Task 6 — Mini-Presentation (Stretch / Optional)

**Goal:** Prove you can teach it back.

**Spec / What you produce:**
- 5–7 slides covering:
  1. What code review is
  2. Why it became a bottleneck
  3. The three categories of solutions
  4. What you tested yourself (Task 4 screenshots)
  5. Your personal recommendation or takeaway

**Acceptance criteria:**
- Each slide has a headline that stands alone (the point, not just the topic)
- You can speak to it for ~2 minutes per slide without reading off the slide

---

## File Index (this project folder)

| File | Purpose |
|------|---------|
| `task2_spec_plan.md` | This document — your roadmap |
| `github_guide.md` | How to create a GitHub repo, clone it, and raise a PR |
| `BuggyCalculator.java` | Java code with intentional issues — use for Task 4 |
| `Charbel_task_2.pdf` | Original brief from your manager |

---

## Evaluation Priorities (from the brief)

1. **Tasks 2 and 5 are weighted highest** — can you explain the bottleneck simply and think critically about it?
2. Correct tool names matter less than understanding why each category exists
3. Honesty beats correctness in Task 5 — "I don't know, but I suspect…" is a strong answer

---

*Last updated: June 24, 2026*
