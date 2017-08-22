package com.sys1yagi.aac_viewmodel_with

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_notification.view.*
import kotlinx.android.synthetic.main.activity_main.tab_layout as tabLayout

class MainActivity : AppCompatActivity(), LifecycleRegistryOwner {

    override fun getLifecycle() = registry

    val registry = LifecycleRegistry(this)

    lateinit var sectionsPagerAdapter: SectionsPagerAdapter

    val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.adapter = sectionsPagerAdapter
        tabLayout.setupWithViewPager(container)

        setupLeftTab()
        setupRightTab()
    }

    fun setupLeftTab() {
        val tab = layoutInflater.inflate(R.layout.tab_notification, null, false)
        tab.tab.text = "Left"
        tab.count.text = "0"
        tabLayout.getTabAt(0)?.customView = tab
        viewModel.left.observe(this, Observer {
            tab.count.text = it.toString()
        })
    }

    fun setupRightTab() {
        val tab = layoutInflater.inflate(R.layout.tab_notification, null, false)
        tab.tab.text = "Right"
        tab.count.text = "0"
        tabLayout.getTabAt(1)?.customView = tab
        viewModel.right.observe(this, Observer {
            tab.count.text = it.toString()
        })
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment =
                NotificationsFragment.newInstance(position == 0)

        override fun getCount(): Int = 2
    }
}
