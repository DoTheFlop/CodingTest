import java.util.*;
class UserSolution {

    List<student> studentList = new ArrayList<>();

    class student{
        int mId;
        int mGrade;
        char mGender;
        int mScore;
    }
    public void init() {
        studentList.clear();
        return;
    }
    public int add(int mId, int mGrade, char mGender[], int mScore) {
        student result = new student();
        student inputStudent = new student();
        inputStudent.mId = mId;
        inputStudent.mGender = mGender[0];
        inputStudent.mGrade = mGrade;
        inputStudent.mScore = mScore;
        studentList.add(inputStudent);
        for(student t : studentList){
            if(t.mGrade == inputStudent.mGrade){
                if(t.mGender == inputStudent.mGender){
                    if (t.mScore < inputStudent.mScore){
                        result = inputStudent;
                    }
                    else if(t.mScore == inputStudent.mScore){
                        if (t.mId > inputStudent.mId){
                            result = t;
                        }
                        else result = inputStudent;
                    }
                    else result = t;
                }
            }
        }
        return result.mId;
    }
    public int remove(int mId) {
        student result = new student();
        System.out.println("돌기전"+studentList.size());
        student studentRemoved = new student();
        Iterator iter = studentList.iterator();
        while(iter.hasNext()) {
            student next = (student) iter.next();
            if(next.mId == mId){
                studentRemoved = next;
                iter.remove();
            }
        }
        for(student t : studentList){
            if(t.mGrade == studentRemoved.mGrade){
                if(t.mGender == studentRemoved.mGender){
                    if (t.mScore < studentRemoved.mScore){
                        result = t;
                    }
                    else if(t.mScore == studentRemoved.mScore){
                        if (t.mId > studentRemoved.mId){
                            result = studentRemoved;
                        }
                        else result = t;
                    }
                    else result = studentRemoved;
                }
            }
        }
        return result.mId;
    }
    public int query(int mGradeCnt, int mGrade[], int mGenderCnt, char mGender[][], int mScore) {

        return 0;
    }
}