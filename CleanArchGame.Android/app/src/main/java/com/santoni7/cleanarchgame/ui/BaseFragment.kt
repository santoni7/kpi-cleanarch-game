package com.santoni7.cleanarchgame.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.santoni7.cleanarchgame.model.ProgressStatus
import com.santoni7.cleanarchgame.viewmodel.BaseViewModel


abstract class BaseFragment : Fragment() {

    abstract val layoutResId: Int

    open val hasToolbar: Boolean = false

    protected val hostActivity
        get() = activity as MainActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResId, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun setupProgressObserver(vm: BaseViewModel){
        vm.progressStatus.observe(this, Observer { status ->
            when(status.state) {
                ProgressStatus.State.LOADING -> showProgress(status.message)
                ProgressStatus.State.DONE -> hideProgress()
//                else -> Log.e(BaseFragment::class.simpleName, "Illegal ProgressStatus: $status")
            }
        })
    }

    open fun showProgress(msg: String? = null) {
        hostActivity.showProgress(msg)
    }

    companion object {
        private val TAG = BaseFragment::class.simpleName
    }

    open fun hideProgress() {
        hostActivity.hideProgress()
    }

    fun toast(msg: String?, len: Int = Toast.LENGTH_SHORT){
        Toast.makeText(context, msg, len).show()
    }

    override fun onDestroyView() {
        hostActivity.hideProgress()
        super.onDestroyView()
    }
}