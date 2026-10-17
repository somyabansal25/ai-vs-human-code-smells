# Code Samples — AI-Generated vs. Human-Written

This folder holds the code we compare in the research paper
*"Evaluating the Code Smells of AI-Generated Code vs. Human-Written Code."*

## How it's organized

Each **task** is one small programming problem (e.g. "reverse a string").
For every task we keep TWO solutions to the SAME problem:

```
code_samples/
├── ai_generated/     <- solutions pasted from ChatGPT / Copilot
│   ├── task01_reverse_string.java
│   ├── task02_palindrome.java
│   └── ...
└── human_written/    <- solutions written by a human (team / textbook / public repo)
    ├── task01_reverse_string.java
    ├── task02_palindrome.java
    └── ...
```

## Rules to keep the comparison fair

1. **Same task, same file name** on both sides (only the folder differs).
   This lets us compare task01 vs task01, etc.
2. **Same programming language** for every sample (we are using **Java**).
3. One self-contained solution per file.
4. Each solution must **actually run / compile** before we analyze it
   (functional validation comes before quality analysis).

## Where to record each sample

Fill in `task_list.csv` as you add files, so the team knows what's done.

## What happens next (the workflow)

1. Collect code into the two folders above.           <- WE ARE HERE
2. Push this repo to GitLab.
3. SonarQube Cloud reads the repo and reports code smells, complexity,
   duplication, and a maintainability rating for the code.
4. We copy those numbers into `figures/make_figures.py` to generate the charts.
