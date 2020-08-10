class LRUCache {
public:
    LRUCache(int capacity): size(capacity) {
        
    }
    
    int get(int key) {
        auto it = data.find(key);
        if (it == data.end()) return -1;
        keyList.push_front( *(it->second));//create new entry in list head
        keyList.erase(it->second);//erase old entry.            
        data[key] = keyList.begin();//update mapa
        return it->second->second;
    }
    
    void put(int key, int value) {
        auto it = data.find(key);
        if (it == data.end()){
            if(keyList.size()==size){
                auto it = keyList.back();
                keyList.pop_back();
                data.erase(it.first);

            }
            keyList.push_front(pair<int,int>(key,value));
            data[key] = keyList.begin();
        }
        else{
            keyList.push_front( pair<int,int>(key,value));
            keyList.erase(it->second);                
            data[key] = keyList.begin();
        }        
    }
private:
    int size;
    list<pair<int, int>> keyList;    
    unordered_map<int,list<pair<int, int>>::iterator> data;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */