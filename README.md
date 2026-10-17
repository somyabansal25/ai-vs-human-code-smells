# Evaluating the Code Smells of AI-Generated Code vs. Human-Written Code

Research project (COOP-1, 22CS411) that compares the structural and
maintainability quality of AI-generated and human-written source code using
static analysis with **SonarQube Cloud**.

- **Repository:** https://github.com/somyabansal25/ai-vs-human-code-smells
- **Analysis dashboard:** SonarQube Cloud (organization `somyabansal25`, Free plan)
- **Language analyzed:** Java

## Repository layout

```
code_samples/
├── ai_generated/     # solutions produced by AI (ChatGPT / Copilot)
├── human_written/    # equivalent solutions written by humans
├── task_list.csv     # tracker of which task files are done
└── README.md         # rules for adding samples
figures/
└── make_figures.py   # generates the bar / pie charts from the measured numbers
```

Each **task** is one small programming problem. For every task there are TWO
solutions to the same problem — one in `ai_generated/`, one in `human_written/` —
with the **same filename** and the **same language (Java)** so they compare fairly.

## Tasks so far

| ID | Task |
|----|------|
| task01 | Reverse a string |
| task02 | Check if a string is a palindrome |
| task03 | Find the largest number in a list |
| task04 | Check if a number is prime |
| task05 | Count word frequency in a sentence |

> The current samples are illustrative, used to validate the analysis pipeline.
> The final study will use genuine AI output and real human solutions across a
> larger task set.

## Workflow (how data flows from code to charts)

```
COLLECT CODE  ->  PUSH TO GITHUB  ->  SONARQUBE ANALYZES  ->  READ NUMBERS  ->  CHARTS
```

1. Add solutions into `code_samples/ai_generated/` and `code_samples/human_written/`.
2. Commit and push to GitHub (the repo is **public**, which keeps SonarQube Cloud free).
3. SonarQube Cloud automatically analyzes each push and reports **code smells,
   complexity, duplication, and a maintainability rating**.
4. Read those numbers from the dashboard and put them into
   `figures/make_figures.py` to generate the comparison charts.

## Where to read the numbers in SonarQube Cloud

- **Overview** tab — summary tiles (Maintainability / code smells count, Duplications).
- **Issues** tab — filter `Type = Code Smell` to see each individual smell.
- **Measures** — Maintainability (technical debt), Complexity, Duplications.
- To compare AI vs. human, drill into the `ai_generated/` and `human_written/`
  folders in the **Code** / **Measures** view and read each folder's values
  separately. Those two values per metric become `ai_counts` / `human_counts`
  in `figures/make_figures.py`.

## Generating the charts

```bash
cd figures
python3 make_figures.py
```

This produces 300-DPI PNGs (grouped bar, pie, stacked bar, quality-metric bar)
ready to embed in the paper. Edit the data block at the top of
`make_figures.py` with the real numbers from SonarQube Cloud.


## Team

Anushi (2310991700), Gurleen Kaur Wer (2310991747), Somya Bansal (2310992374).
Supervisor: Dr. Anshu Singla — Chitkara University, Punjab, India.
