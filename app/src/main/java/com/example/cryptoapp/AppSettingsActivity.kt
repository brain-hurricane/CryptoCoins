package com.example.cryptoapp

import AppSettings
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cryptoapp.databinding.ActivityAppSettingsBinding


class AppSettingsActivity : AppCompatActivity() {

    private val currentCurrency: String by lazy {
        AppSettings(this).getCurrency()
    }

    private val binding: ActivityAppSettingsBinding by lazy {
        ActivityAppSettingsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val values = Currency.values().map { it.toString() }

        var currentId = 0
        for (i in values.indices) {
            if (values[i] == currentCurrency) {
                currentId = i
                break
            }
        }

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item ,values)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCurrency.adapter = adapter
        binding.spinnerCurrency.setSelection(currentId)

        binding.spinnerCurrency.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p1?.let {
                    AppSettings(it.context).setCurrency(values[p2])
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@AppSettingsActivity, "Nothing is selected", Toast.LENGTH_SHORT).show()
            }
        };

    }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, AppSettingsActivity::class.java)
        }
    }
}