package com.demirli.a19loremipsumgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sentenceList: List<String>

    private var paragraphText = ""
    private var fullText = ""

    private var paragraphsNumber = 0
    private var randomSentenceNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSentenceList()

        generate_loremIpsum_btn.setOnClickListener {

            lorem_ipsum_tv.setText("")
            fullText = "Lorem ipsum dolor sit amet. "

            if(paragraphs_number_et.text.toString() != ""){
                paragraphsNumber = paragraphs_number_et.text.toString().toInt()
            }

            for(j in 0 until paragraphsNumber){

                paragraphText = ""
                val shuffledsentenceList = sentenceList.shuffled()
                randomSentenceNumber =  (3..sentenceList.size).shuffled().first()

                for (i in 0 until randomSentenceNumber){
                    paragraphText = paragraphText + shuffledsentenceList[i] + " "
                }

                fullText = fullText + paragraphText + "\n\n"
            }
            lorem_ipsum_tv.setText(fullText)
        }
    }

    fun createSentenceList(){
        sentenceList = listOf(
            "Phasellus a semper augue.",
            "Aliquam sit amet libero porta, rhoncus tellus at, venenatis dolor.",
            "Phasellus eu accumsan mauris.",
            "Vestibulum nisi tortor, tincidunt et ultrices ut, congue vitae nulla.",
            "Nam non velit eu orci hendrerit suscipit quis vitae justo.",
            "Donec feugiat enim ac hendrerit pellentesque.",
            "Curabitur venenatis feugiat dolor, eget sagittis odio posuere id.",
            "Nullam cursus, mi sed sagittis luctus, turpis nisl placerat nisl, at vulputate orci metus eget enim.",
            "Quisque commodo aliquam lacus ut dignissim.",
            " Sed eleifend vehicula neque lacinia tempor."
        )
    }
}
