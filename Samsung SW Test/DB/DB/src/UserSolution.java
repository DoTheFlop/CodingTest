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

        int count = 0;

        for (student student : studentList) {
            if(student.mGrade == inputStudent.mGrade && student.mGender == inputStudent.mGender){
                count++;
            }
        }
        if(count == 1){
            return inputStudent.mId;
        }

        int max_score = 0;
        for(student t : studentList){
            if(t.mGrade == inputStudent.mGrade && t.mGender == inputStudent.mGender){
                if (max_score < t.mScore){
                    max_score = t.mScore;
                    result = t;
                }
                else if(max_score == t.mScore){
                    if(result.mId < t.mId){
                        result = t;
                    }
                }
            }
        }

        return result.mId;
    }
    public int remove(int mId) {
        student result = new student();
        student studentRemoved = new student();

        Iterator iter = studentList.iterator();
        int count = 0;

        while(iter.hasNext()) {
            student next = (student) iter.next();
            if(next.mId == mId){
                studentRemoved = next;
                iter.remove();
                break;
            }
        }

        int min_score = 300000;

        for(student t : studentList){
            if(t.mGrade == studentRemoved.mGrade && t.mGender == studentRemoved.mGender){
                if(min_score > t.mScore){
                    min_score = t.mScore;
                    result = t;
                    count++;
                }
                else if(min_score == t.mScore){
                    if(result.mId > t.mId){
                        return t.mId;
                    }
                }
            }
        }

        if(count == 0) return 0;

        return result.mId;
    }
    public int query(int mGradeCnt, int[] mGrade, int mGenderCnt, char mGender[][], int mScore) {
        List<student> result = new ArrayList<>();
        List<Integer> gradeList = new ArrayList<>();

        for(int i : mGrade){
            if(i > 0) gradeList.add(i);
        }

        for(student t : studentList){
            if(gradeList.contains(t.mGrade) && (mGender[1][0] == t.mGender || mGender[0][0] == t.mGender)){
                if (t.mScore >= mScore){
                    result.add(t);
                }
            }
        }

        if (result.size() == 0) return 0;

        int min_score =  300000;

        student answer = new student();

        for(student t : result){
            if(min_score > t.mScore){
                min_score = t.mScore;
                answer = t;
            }
            else if(min_score == t.mScore){
                if(answer.mId > t.mId){
                    answer = t;
                }
            }
        }

        return answer.mId;
    }
}