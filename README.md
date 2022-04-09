###CSCI 491: Software Reliability & Testing
###Homework 6 - Writing a Linter
###John Harrington 
###April 8, 2022

For best results, download and install AndroidStudio, an IDE for developing Android applications, develped by JetBrains and Google:
https://developer.android.com/studio

Unzip this assignment submission and open the IDE. Open the directory created when unzipping this assignment submission. If prompted to trust the Gradle project, click yes. Gradle should automatically build the project. If not, find the 'Build' dropdown menu at the top of the screen and click 'Build Project' 

You may want to explore the applicatio to get a better idea of what is going on. Click the green play icon to run the application, doing so will be informative and demonstrate the purpose of creating this particular lint. 

If you do so, you will notice the inout field at the top of the second fragment does not contain a hint describing its purpose, this is not an ideal user experience. Compare to the input field at the bottom of the second fragment to get a better idea of what a hint is. 

The lint I created is contained in the 'lint-checks' library of my project. View `/CustomLinter/lint-checks/src/main/java/com.harr1424.lint_checks/InputHintDetector.kt` to view the logic for this lint. The file `LintRegistry.kt` is also necessary in order to create a list of detected lint violations. 

Before running the lint, examine the file `/CustomLinter/app/src/main/res/layout/fragment_second.xml` and explore the `Editext` elements. Note that the `EditText` with the id `editTextTextMultiLine2` has a declared hint attribute, but the EditText with id `editTextTextMultiLine` does not. This will produce an `ERROR` when running the lint, which will result in build failure (as opposed to a `WARNING` which would not terminate the build process. 

To run the lint, open a terminal window in the IDE (bottom left, similar to PyCharm) and enter the command `./gradlew lint`
