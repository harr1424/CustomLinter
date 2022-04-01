package com.harr1424.lint_checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

class LintRegistry : IssueRegistry() {
    override val api: Int
        get() = CURRENT_API

    override val issues: List<Issue>
        get() = listOf(
            InputTypeDetector.ISSUE_MISSING_INPUT_TYPE
        )
}