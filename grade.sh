CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'

if [[ -f student-submission/ListExamples.java ]]
then
    echo "ListExamples.java file found"
else
    echo "ListExamples.java file not found"
    echo "Grade: 0"
    exit
fi

cp TestListExamples.java student-submission/ListExamples.java grading-area
cp -r lib grading-area

cd grading-area

#set -e
javac -cp $CPATH *.java

echo "The exit code for the compile step is $?"
java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > testresult.txt

result=$(grep "." testresult.txt |tail -1)
echo $result

#testNum=2

fullCredit="OK (2 tests)"
halfCredit="Tests run: 2,  Failures: 1"
error_halfCredit="OK (1 test)"

if [[ "$result" == "$fullCredit" ]]
then
    echo "Grade:100"
elif [[ "$result" == "$halfCredit" ]]
then
    echo "Grade:50"

elif [[ "$result" == "$error_halfCredit" ]]
then
    echo "Grade:50, error occuring on one of the tests"
else
    echo "Grade:0"
fi



# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
