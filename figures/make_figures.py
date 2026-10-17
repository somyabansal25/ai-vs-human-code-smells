"""
Figure generator for the research paper:
"Evaluating the Code Smells of AI-Generated Code vs. Human-Written Code"

Run:  python3 make_figures.py
Output: PNG files (300 DPI) in the same folder, ready to embed in Word/LaTeX.

Replace the SAMPLE DATA below with your real static-analysis results.
"""

import numpy as np
import matplotlib.pyplot as plt

# ----------------------------------------------------------------------
# 1. YOUR DATA  --  edit these numbers with your real measurements
# ----------------------------------------------------------------------
smells        = ["Long Method", "Duplicated Code", "Large Class",
                 "Dead Code", "Long Param List"]
ai_counts     = [42, 35, 18, 12, 20]      # smells found in AI-generated code
human_counts  = [28, 15, 22,  6, 14]      # smells found in human-written code

# For the pie chart: total smell distribution for ONE group (e.g. AI code)
pie_labels    = smells
pie_values    = ai_counts

# A quality metric averaged per group (0-100, higher = better)
metrics       = ["Maintainability", "Readability", "Low Complexity", "Low Coupling"]
ai_metric     = [68, 72, 60, 65]
human_metric  = [80, 78, 74, 77]

# Consistent, print-friendly colours
AI_COLOR, HUMAN_COLOR = "#4C72B0", "#DD8452"

# Make all text large enough to read when shrunk into a two-column paper
plt.rcParams.update({"font.size": 12, "savefig.dpi": 300, "savefig.bbox": "tight"})


# ----------------------------------------------------------------------
# 2. GROUPED BAR CHART  --  compare smell counts side by side
# ----------------------------------------------------------------------
def grouped_bar():
    x = np.arange(len(smells))
    width = 0.38
    fig, ax = plt.subplots(figsize=(8, 4.5))
    b1 = ax.bar(x - width/2, ai_counts, width, label="AI-Generated", color=AI_COLOR)
    b2 = ax.bar(x + width/2, human_counts, width, label="Human-Written", color=HUMAN_COLOR)
    ax.set_ylabel("Number of Code Smells")
    ax.set_title("Code Smell Frequency: AI-Generated vs. Human-Written")
    ax.set_xticks(x)
    ax.set_xticklabels(smells, rotation=20, ha="right")
    ax.legend()
    ax.bar_label(b1, padding=2, fontsize=9)
    ax.bar_label(b2, padding=2, fontsize=9)
    fig.savefig("fig_grouped_bar.png")
    plt.close(fig)


# ----------------------------------------------------------------------
# 3. PIE CHART  --  share of each smell type within one group
# ----------------------------------------------------------------------
def pie_chart():
    fig, ax = plt.subplots(figsize=(6, 6))
    ax.pie(pie_values, labels=pie_labels, autopct="%1.1f%%",
           startangle=90, counterclock=False,
           wedgeprops={"edgecolor": "white"})
    ax.set_title("Distribution of Code Smells in AI-Generated Code")
    ax.axis("equal")  # keep it a circle
    fig.savefig("fig_pie_chart.png")
    plt.close(fig)


# ----------------------------------------------------------------------
# 4. STACKED BAR  --  total smells per group, broken down by type
# ----------------------------------------------------------------------
def stacked_bar():
    groups = ["AI-Generated", "Human-Written"]
    data = np.array([ai_counts, human_counts])  # rows = groups
    fig, ax = plt.subplots(figsize=(6, 4.5))
    bottom = np.zeros(len(groups))
    cmap = plt.get_cmap("tab20")
    for i, smell in enumerate(smells):
        vals = data[:, i]
        ax.bar(groups, vals, bottom=bottom, label=smell, color=cmap(i))
        bottom += vals
    ax.set_ylabel("Total Code Smells")
    ax.set_title("Composition of Code Smells per Group")
    ax.legend(bbox_to_anchor=(1.02, 1), loc="upper left", fontsize=9)
    fig.savefig("fig_stacked_bar.png")
    plt.close(fig)


# ----------------------------------------------------------------------
# 5. QUALITY METRIC BAR  --  normalised quality scores
# ----------------------------------------------------------------------
def metric_bar():
    x = np.arange(len(metrics))
    width = 0.38
    fig, ax = plt.subplots(figsize=(8, 4.5))
    ax.bar(x - width/2, ai_metric, width, label="AI-Generated", color=AI_COLOR)
    ax.bar(x + width/2, human_metric, width, label="Human-Written", color=HUMAN_COLOR)
    ax.set_ylabel("Score (0-100, higher is better)")
    ax.set_ylim(0, 100)
    ax.set_title("Software-Quality Metrics by Group")
    ax.set_xticks(x)
    ax.set_xticklabels(metrics, rotation=15, ha="right")
    ax.legend()
    fig.savefig("fig_metric_bar.png")
    plt.close(fig)


if __name__ == "__main__":
    grouped_bar()
    pie_chart()
    stacked_bar()
    metric_bar()
    print("Done. Created: fig_grouped_bar.png, fig_pie_chart.png, "
          "fig_stacked_bar.png, fig_metric_bar.png")
