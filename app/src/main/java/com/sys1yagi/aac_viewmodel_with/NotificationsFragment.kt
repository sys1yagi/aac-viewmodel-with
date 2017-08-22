package com.sys1yagi.aac_viewmodel_with

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sys1yagi.aac_viewmodel_with.extensions.gone
import com.sys1yagi.aac_viewmodel_with.extensions.visible
import kotlinx.android.synthetic.main.fragment_notifications.view.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import java.util.*
import kotlinx.android.synthetic.main.fragment_notifications.view.recycler_view as recyclerView

class NotificationsFragment : Fragment() {

    companion object {
        fun newInstance() = NotificationsFragment()
    }

    val adapter = NotificationAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_notifications, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerView.apply {
            adapter = this@NotificationsFragment.adapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        view.progress.visible()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadData()
    }

    fun loadData() {
        launch(UI) {
            delay(Math.abs(Random().nextLong() % 2000))
            adapter.items = 1.until(100).map { it.toString() }
            adapter.notifyDataSetChanged()
            view?.progress?.gone()
        }
    }
}
