package com.nmproject.quizapp.myoggproject
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        supportActionBar?.hide()

        val values = arrayListOf("100.DÖNEM", "98.DÖNEM", "96.DÖNEM", "94.DÖNEM", "92.DÖNEM")
        val mListView = findViewById<ListView>(R.id.listview)
        val adapter = ArrayAdapter(this, R.layout.list_item, R.id.text_view, values)
        mListView.adapter = adapter
        mListView.setOnItemClickListener { _, _, position, _ ->
            if (position == 0) {
                Toast.makeText(this@ItemsActivity, "100.Dönem çıkmış soruları", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Donem", position)
                startActivity(intent)
            }
            if (position == 1) {
                Toast.makeText(this@ItemsActivity, "98.Dönem çıkmış sorular", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Donem", position)
                startActivity(intent)
            }
            if (position == 2) {
                Toast.makeText(this@ItemsActivity, "96.Dönem çıkmış sorular", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Donem", position)
                startActivity(intent)
            }
            if (position == 3) {
                Toast.makeText(this@ItemsActivity, "94.Dönem çıkmış sorular", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Donem", position)
                startActivity(intent)
            }
            if (position == 4) {
                Toast.makeText(this@ItemsActivity, "92.Dönem çıkmış sorular", Toast.LENGTH_SHORT)
                    .show()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Donem", position)
                startActivity(intent)
            }
        }
    }
}