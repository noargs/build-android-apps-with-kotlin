### Fragment Lifecycle

- we will create and add a basic fragment to an app
- to demonstrate, how fragments are added to an activity and layout they display
- fragment lifecycle method nearly identical to activity lifecycle methods
- interaction between fragments and activities in [android developer site](https://developer.android.com/guide/fragments/lifecycle)
- following callbacks mentioned are to be used often
- complete list of callback in the [official documentation](https://developer.android.com/guide/fragments)


**onAttach**
`override fun onAttach(context: Context)`
- fragment is linked to activity at this stage
- allows you to reference the activity
- neither the fragment nor activity has been fully created

**onCreate**
`override fun onCreate(savedInstanceState: Bundle?)`
- here you can do any initialisation of your fragment
- cannot set the layout for your fragment as no UI available to display
- no `setContentView` available for fragment as in an activity
- you can use `saveInstanceState` to restore the state of the fragment

**onCreateView**
`override fun onCreateView(inflate: LayoutInflate, container: ViewGroup?,
    savedInstanceState: Bundle?): View?`
- this is where you get to create the layout of your fragment.
- you cannot set the layout as you do in activity 
- the fragment will actually return the layout `View` from this function
- views you have in your layout are available to refer to
- better to do view manipulation in `onViewCreated`

**onViewCreated**
`override fun onViewCreated(view View, savedInstanceState: Bundle?)`
- this callback runs when fragment is fully created and visible to the user
- you can set up your views and add any functionality and interactivity to these views
- i.e. adding *click listener* to a button and then calling a function when its clicked

**onActivityCreated**
`override fun onActivityCreated(context: Context)`
- is called immediately after the activity's `onCreate` has been run
- most of the view state initialisation of the fragment will be done
- this is the place to do any final setup if required

**onStart**
`override fun onStart()`
- this is called when the fragment is about to become visible to the user
- *But* not available to interact with

**onResume**
`override fun onResume()`
- at the end of this call fragment is available for user to interact with
- minimal functionality defined as this callback runs everytime apps goes
- to background and comes back to foreground

**onPause**
`override fun onPause()`
- like its counterpart, *onPause()* in an activity, signals your app is going into background
- or has been partially covered by something else on the screen
- use this to save any changes to the fragment state

**onStop**
`override fun onStop()`
- fragment is no longer visible at the end of this callback 
- and goes into background

**onDestroyView**
`override fun onDestroyView()`
- usually called for final clean-up before the fragment is destroyed
- call it to clean-up any resources
- if the fragment is pushed to the back stack and retained then it can also be called
- without destroying the fragment
- on completion of this callback the fragment's layout view is removed

**onDestroy**
`override fun onDestroy()`
- the fragment is being destroyed.
- this occur because app is being killed or fragment is replaced by another one.

**onDetach**
`override fun onDestach()`
- called when fragment is detached from its activity