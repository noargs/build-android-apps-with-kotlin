### Planet quiz app   
   
    
- Add `FragmentContainerView` into `app/build.gradle`
```
    implementation 'androidx.fragment:fragment-ktx:1.2.5'
```   
- this app used dynamic fragments and a listener in a *QuestionsFragment*
- class to pass data to an *AnswersFragment* with the fragment being added
- to a container *ViewGroup* in the activity layout file