package learnprogramming.academy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENTS = "TextContent"

// class MainActivity extends AppCompatActivity()
class MainActivity : AppCompatActivity() {

    //By appending a question mark to the type, we let the compiler (and other programmers) know that the variable is nullable
    //https://stackoverflow.com/questions/53453142/android-question-mark-after-variable
    private var textView: TextView? = null //we have to initialize variables in Kotlin, hence the question mark as we're initializing it as null

    /*private var numTimesClicked: Int = 0*/


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.editText)  //R here is for resources
        val button: Button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        textView?.text=""  // Setting it as empty string on startup
        textView?.movementMethod = ScrollingMovementMethod()  // To make it scrollable (Also additionally do set "ScrollBars" & "ScrollIndicators" in the design pane / layout, only then it works)

        userInput.text.clear()  // or userInput.setText("") To clear initial text on the widget

        button.setOnClickListener(object : View.OnClickListener {  //this function tells what to do when a button is clicked
            override fun onClick(v: View?) {
                Log.d(TAG, "onClick: called")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.text.clear()  // to Clear the text after button is pressed
                //userInput.setText("") // Another way of clearing the text is to set an empty string

               /* numTimesClicked += 1
                Log.i("INFO","the button got tapped $numTimesClicked time")
                textView?.append("The button got tapped $numTimesClicked time")

                if(numTimesClicked != 1){
                    textView?.append("s\n")   // time"s"
                } else {
                    textView?.append("\n")
                }*/
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart: called")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState: called")
        super.onRestoreInstanceState(savedInstanceState)
        //2)Getting the key "TEXT_CONTENTS" value and putting on the textView, default value "" is optional here
        textView?.text = savedInstanceState?.getString(TEXT_CONTENTS,"")
    }

    override fun onResume() {
        Log.d(TAG, "onResume: called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: called")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: called")
        super.onSaveInstanceState(outState)
        //1)Saving  the key "TEXT_CONTENTS" eith value of textView
        outState?.putString(TEXT_CONTENTS, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop: called")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart: called")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: called")
        super.onDestroy()
    }
}

//State refers to the things that needs to be restored to make things like a device rotation appear seamless to the user
//apps' state get destroyed once rotated
//refer Steps 1) & 2) to achieve this