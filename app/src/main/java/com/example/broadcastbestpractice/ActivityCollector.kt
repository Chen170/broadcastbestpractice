package com.example.broadcastbestpractice

import android.app.Activity

/**
 *   created by 李大辰
 *   on 2020/4/29
 */
object ActivityCollector {

    private var activities = ArrayList<Activity>()

    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    fun finishAll() {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }
}