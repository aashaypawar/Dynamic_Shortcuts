package com.example.dynamic_shortcuts

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var shortcutManager = getSystemService(ShortcutManager::class.java)
        var shortcut1 = ShortcutInfo.Builder(applicationContext,"ID1")
                .setShortLabel("Instagram")
                .setIcon(Icon.createWithResource(applicationContext,R.drawable.icon))
                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com")))
                .build()
        var shortcut2 = ShortcutInfo.Builder(applicationContext,"ID2")
                .setShortLabel("AskFM")
                .setIcon(Icon.createWithResource(applicationContext,R.drawable.icon))
                .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ask.fm")))
                .build()

        shortcutManager!!.dynamicShortcuts = listOf(shortcut1,shortcut2)

        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener {

            shortcut1 = ShortcutInfo.Builder(applicationContext,"ID1")
                    .setShortLabel("Google")
                    .setIcon(Icon.createWithResource(applicationContext,R.drawable.icon))
                    .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))
                    .build()
            shortcut2 = ShortcutInfo.Builder(applicationContext,"ID2")
                    .setShortLabel("Facebook")
                    .setIcon(Icon.createWithResource(applicationContext,R.drawable.icon))
                    .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com")))
                    .build()

            shortcutManager!!.dynamicShortcuts = listOf(shortcut1,shortcut2)
        }

        val add = findViewById<Button>(R.id.append)

        add.setOnClickListener {
            var shortcut3 = ShortcutInfo.Builder(applicationContext,"ID3")
                    .setShortLabel("NewlyAppended")
                    .setIcon(Icon.createWithResource(applicationContext,R.drawable.icon))
                    .setIntent(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.newlyAppended.com")))
                    .build()

            shortcutManager!!.dynamicShortcuts = listOf(shortcut1,shortcut2,shortcut3)
        }
    }
}