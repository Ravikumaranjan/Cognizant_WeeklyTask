# Git-HOL 4 Solutions

1. Verify if master is in clean state.
`git status`

2. Create a branch GitWork. Add a file hello.xml.
`git checkout -b GitWork`
`echo "<hello>Branch Content</hello>" > hello.xml`
`git add hello.xml`

3. Update the content of hello.xml and observe the status
`echo "<hello>Updated Branch Content</hello>" > hello.xml`
`git status`

4. Commit the changes to reflect in the branch
`git add hello.xml`
`git commit -m "Added hello.xml in GitWork branch"`

5. Switch to master.
`git checkout master`

6. Add a file hello.xml to the master and add some different content than previous.
`echo "<hello>Master Content</hello>" > hello.xml`
`git add hello.xml`

7. Commit the changes to the master
`git commit -m "Added hello.xml in master branch"`

8. Observe the log by executing git log --oneline --graph --decorate --all
`git log --oneline --graph --decorate --all`

9. Check the differences with Git diff tool
`git diff GitWork`

10. For better visualization, use P4Merge tool to list out all the differences between master and branch
`git difftool -t p4merge GitWork`

11. Merge the bran to the master
`git merge GitWork`

12. Observe the git mark up.
`cat hello.xml`

13. Use 3-way merge tool to resolve the conflict
`git mergetool -t p4merge`

14. Commit the changes to the master, once done with conflict
`git commit -m "Resolved merge conflict"`

15. Observe the git status and add backup file to the .gitignore file.
`git status`
`echo "*.orig" >> .gitignore`

16. Commit the changes to the .gitignore
`git add .gitignore`
`git commit -m "Ignored backup files"`

17. List out all the available branches
`git branch -a`

18. Delete the branch, which merge to master.
`git branch -d GitWork`

19. Observe the log by executing git log --oneline --graph --decorate
`git log --oneline --graph --decorate`
