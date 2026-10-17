# Evaluating the Code Smells of AI-Generated Code vs. Human-Written Code

Research project (COOP-1) comparing the code quality of AI-generated and
human-written source code using static analysis (SonarQube).

## Repository layout

```
code_samples/
├── ai_generated/    # solutions produced by AI (ChatGPT / Copilot)
└── human_written/   # solutions written by humans
figures/
└── make_figures.py  # generates the bar / pie charts from the measured numbers
```

Each task has one solution on each side, same filename, same language (Java).

## Workflow

1. Collect code into `code_samples/`.
2. Push this repo to GitLab (public).
3. SonarQube Cloud analyzes the repo and reports code smells, complexity,
   duplication, and maintainability.
4. The measured numbers go into `figures/make_figures.py` to produce the charts.
