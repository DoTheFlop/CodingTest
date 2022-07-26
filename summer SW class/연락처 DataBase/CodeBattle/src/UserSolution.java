import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class UserSolution {

    HashMap<String, Data> database;

    class Data {
        String name;
        String number;
        String birthday;
        String email;
        String memo;

        public Data(String name, String number, String birthday, String email, String memo) {
            this.name = name;
            this.number = number;
            this.birthday = birthday;
            this.email = email;
            this.memo = memo;
        }
    }


    void InitDB()
    {
        database = new HashMap<>();
    }

    void Add(String name, String number, String birthday, String email, String memo)
    {
        Data data = new Data(name, number, birthday, email, memo);
        database.put(number, data);
    }

    int Delete(int field, String str)
    {
        List<String> keyList = new LinkedList<>();
        for( String strKey : database.keySet() ){
            Data data = database.get(strKey);
            switch (field) {
                case 0:
                    if(data.name.equals(str)){
                        keyList.add(strKey);
                    }
                case 1:
                    if(data.number.equals(str)){
                        keyList.add(strKey);
                    }
                case 2:
                    if(data.birthday.equals(str)){
                        keyList.add(strKey);
                    }
                case 3:
                    if(data.email.equals(str)){
                        keyList.add(strKey);
                    }
                case 4:
                    if(data.memo.equals(str)){
                        keyList.add(strKey);
                    }
                default:
                    String key = "none";
            }
        }

        int result = 0;
        for (String s : keyList) {
            database.remove(s);
            result++;
        }
        return result;
    }

    int Change(int field, String str, int changefield, String changestr)
    {
        int result = 0;
        for( String strKey : database.keySet() ){
            Data data = database.get(strKey);
            switch (field) {
                case 0:
                    if(data.name.equals(str)){
                        Data temp = changeField(changefield, data, changestr);
                        database.replace(strKey, temp);
                        result++;
                    }
                case 1:
                    if(data.number.equals(str)){
                        Data temp = changeField(changefield, data, changestr);
                        database.replace(strKey, temp);
                        result++;
                    }
                case 2:
                    if(data.birthday.equals(str)){
                        Data temp = changeField(changefield, data, changestr);
                        database.replace(strKey, temp);
                        result++;
                    }
                case 3:
                    if(data.email.equals(str)){
                        Data temp = changeField(changefield, data, changestr);
                        database.replace(strKey, temp);
                        result++;
                    }
                case 4:
                    if(data.memo.equals(str)){
                        Data temp = changeField(changefield, data, changestr);
                        database.replace(strKey, temp);
                        result++;
                    }
                default:
                    String key = "none";
            }
        }

        return result;
    }


    Data changeField(int changeField, Data org, String changeStr){
        switch (changeField) {
            case 0:
                return new Data(changeStr, org.number, org.birthday, org.email, org.memo);
            case 1:
                return new Data(org.name, changeStr, org.birthday, org.email, org.memo);
            case 2:
                return new Data(org.name, org.number, changeStr, org.email, org.memo);
            case 3:
                return new Data(org.name, org.number, org.birthday, changeStr, org.memo);
            case 4:
                return new Data(org.name, org.number, org.birthday, org.email, changeStr);
            default:
                String key = "none";
        }
        return null;
    }


    Solution.Result Search(int field, String str, int returnfield)
    {
        Solution.Result result = new Solution.Result();
        result.count = 0;

        for( String strKey : database.keySet() ){
            Data data = database.get(strKey);
            switch (field) {
                case 0:
                    if(data.name.equals(str)){
                        result.count++;
                        result.str = data.name;
                    }
                case 1:
                    if(data.number.equals(str)){
                        result.count++;
                        result.str = data.number;
                    }
                case 2:
                    if(data.birthday.equals(str)){
                        result.count++;
                        result.str = data.birthday;
                    }
                case 3:
                    if(data.email.equals(str)){
                        result.count++;
                        result.str = data.email;
                    }
                case 4:
                    if(data.memo.equals(str)){
                        result.count++;
                        result.str = data.memo;
                    }
                default:
                    String key = "none";
            }
        }
        return result;
    }
}
