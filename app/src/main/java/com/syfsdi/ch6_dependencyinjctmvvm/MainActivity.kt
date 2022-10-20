package com.syfsdi.ch6_dependencyinjctmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.syfsdi.ch6_dependencyinjctmvvm.databinding.ActivityMainBinding
import com.syfsdi.ch6_dependencyinjctmvvm.view.MakeupAdapter
import com.syfsdi.ch6_dependencyinjctmvvm.viewmodel.ViewModelMakeup
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var makeupAdapter: MakeupAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setVmtoAdapter()
    }

    fun setVmtoAdapter(){
        val viewModel = ViewModelProvider(this).get(ViewModelMakeup::class.java)
        viewModel.callApi()
        viewModel.getliveDataMakeup().observe(this, Observer {
            makeupAdapter = MakeupAdapter(it)
            if ( it != null){
                binding.rvMakeup.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvMakeup.adapter = MakeupAdapter(it)
            }
        })
    }
}