# Android_ButtonCounter

-Extensively used Constraint Layoutes & positioning widgets
-Used Baseline Constraints
-Add scrolling capabilities
-Events & setOnClickListener on Button used
-Complete Activity lifecycle LOGGED using logger
ActivityLifecycle : 
  //State refers to the things that needs to be restored to make things like a device rotation appear seamless to the user
//apps' state get destroyed once rotated
//refer Steps 1) & 2) to achieve this
 1)Save state on "onSaveInstanceState()" function
 2)Restore State on "onRestoreInstanceState()" function
 
 
 Reference DOCs :
 https://developer.android.com/guide/components/activities/activity-lifecycle
 https://developer.android.com/reference/android/app/Activity.html
