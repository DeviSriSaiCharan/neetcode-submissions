class Pair {
    int timestamp;
    String value;
    Pair(int timestamp, String val) {
        this.timestamp = timestamp;
        this.value = val;
    }
}

class TimeMap {
    HashMap<String, ArrayList<Pair>> mpp;

    public TimeMap() {
        this.mpp = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        // Lets check if key exists or not
        if(!this.mpp.containsKey(key)) {
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(timestamp, value));

            this.mpp.put(key, arr);
        } else {
            ArrayList<Pair> values = this.mpp.get(key);
            values.add(new Pair(timestamp, value));

            this.mpp.put(key, values);
        }
    }
    
    public String get(String key, int timestamp) {

        if(!this.mpp.containsKey(key)) return "";

        ArrayList<Pair> values = this.mpp.get(key);

        int n = values.size();

        if(n == 0) return "";

        int left = 0, right = n-1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(values.get(mid).timestamp == timestamp) return values.get(mid).value;
            else if(values.get(mid).timestamp > timestamp) right = mid - 1;
            else left = mid + 1;
        }

        if(right < 0) return "";

        return values.get(right).value; 
    }
}
