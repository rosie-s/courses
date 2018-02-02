# Lesson 1
## Comparing Files
- Windows		
```
FC - <File> <Compare>
```
- Mac/Linux
```
diff -u <old> <new>
```

## See more stats
``` 
git log --stat
```

## Global colour set up 
Shows colours when using diff
```
git config --global color.ui auto
```

## Setting up workspace
```
mv Desktop/git-completion.bash git-completion.bash
mv Desktop/git-prompt.sh git-prompt.sh
```

## Add notepad alias to bash_profile
```
alias npp="/c/Program\ Files\ \(x86\)/Notepad++/notepad++.exe"
```

## Config 
```
git config --global push.default upstream
git config --global merge.conflictstyle diff3
git config --global user.email "<EmailAddress>"
```
# Reflection
Click [here](https://github.com/rosie-s/reflections/blob/master/lesson_1_reflections.txt) for Lesson 1's reflection
