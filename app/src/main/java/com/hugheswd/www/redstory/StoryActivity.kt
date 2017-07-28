package com.hugheswd.www.redstory

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_story.*

import android.os.Bundle
import android.view.View

class StoryActivity : AppCompatActivity() {

    var page = 0
    var images = ArrayList<Drawable>()
    var storyTexts = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val extras = intent.extras
        val nobody = extras.get("nobodyExtra")

        val pageZero = "Where am I? How did I get here? I can feel the cold damp earth below me. I can hear the soft rustle of leaves on the trees. But no animals, no insects, no life. Life. Am I alive? Did I die? My mind is devoid of.....everything.\n" +
                "\"Oh, good. You're awake.\""
        val pageOne = "I remember. It all came rushing back. The last thing I saw. Those scarlet eyes. The purr of their voice slicing through the silence like the blade of a well sharpened katana through an enemy. I remember the spray of blood. The hot sticky wetness across my face.\n" +
                "\"Are you just going to lay there all day? Get up, %s.\"".format(nobody)
        val pageTwo = "Get up. Seems simple enough. But my body felt so heavy. And my head started to pound with the effort. When I opened my eyes, the dark forest pitched. I slammed my eyes shut again. Trying in vain to will the world to stop spinning. \n" +
                "\"Jeez, %s. Get a hold of yourself.\"".format(nobody)
        val pageThree = "It is hard to believe this was the same person as before. They used to look and act so sweet. Then again, they always appeared differently depending on who viewed them."
        val pageFour = "And, for me, they always switched between the two."
        val pageFive = "\"Welcome to world of darkness. You will get used to the scarlet eyes. The reason you feel dizzy right now is because your equilibrium is still adjusting.\" \n" +
                "\"What am I?\" My voice felt foreign in my throat. \n" +
                "\"I'd have thought it would have been obvious by now, %s.\" They purred, \"Why, you're a vampire, of course.\"".format(nobody)

        images.add(getDrawable(R.drawable.red_dark_forest))
        images.add(getDrawable(R.drawable.red_og))
        images.add(getDrawable(R.drawable.red_dark_forest))
        images.add(getDrawable(R.drawable.red_cute_girl))
        images.add(getDrawable(R.drawable.red_cute_boy))
        images.add(getDrawable(R.drawable.red_dark_forest))

        storyTexts.add(pageZero)
        storyTexts.add(pageOne)
        storyTexts.add(pageTwo)
        storyTexts.add(pageThree)
        storyTexts.add(pageFour)
        storyTexts.add(pageFive)

        pageTurner()

        lenext.setOnClickListener {
            page ++
            pageTurner()
        }
        leprevious.setOnClickListener {
            page --
            pageTurner()
        }

    }

    fun pageTurner(){

        if (page >= images.size - 1){
            page = images.size - 1
            lenext.visibility = View.GONE
        } else {lenext.visibility = View.VISIBLE}
        if (page <= 0){
            page = 0
            leprevious.visibility = View.GONE
        } else{leprevious.visibility = View.VISIBLE}



        leimage.setImageDrawable(images.get(page))
        letext.text = storyTexts.get(page)
    }

}
