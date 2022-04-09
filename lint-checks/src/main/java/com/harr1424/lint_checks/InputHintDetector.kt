package com.harr1424.lint_checks

import com.android.SdkConstants
import com.android.tools.lint.detector.api.*

class InputHintDetector: LayoutDetector() {
    companion object {
        @JvmStatic
        internal val ISSUE_MISSING_INPUT_HINT = Issue.create(
            id = "MissingInputHint",
            briefDescription = "Specify hint attribute to provide the user withcontext of the input field.",
            explanation = "You should provide a hint for each EditText so that the user understands what information it should receive.",
            category = Category.USABILITY,
            priority = 8,
            severity = Severity.ERROR,
            implementation = Implementation(
                InputHintDetector::class.java,
                Scope.ALL_RESOURCES_SCOPE
            )
        ).addMoreInfo("https://developer.android.com/reference/android/widget/EditText")
    }

    override fun getApplicableElements(): Collection<String>? {
        return listOf(
            SdkConstants.EDIT_TEXT,
            "androidx.appcompat.widget.AppCompatEditText",
            "android.support.v7.widget.AppCompatEditText"
        )
    }

    override fun visitElement(context: XmlContext, element: org.w3c.dom.Element) {
        if (!element.hasAttribute(SdkConstants.ATTR_HINT)) { // Check if the element has the `android:hint` attribute
            context.report(
                issue = ISSUE_MISSING_INPUT_HINT, // The issue that we defined above
                location = context.getLocation(element),
                message = ISSUE_MISSING_INPUT_HINT.getExplanation(TextFormat.TEXT)
            )
        }
    }
}