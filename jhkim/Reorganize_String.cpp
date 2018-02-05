class Solution {
public:
    string reorganizeString(string S) {
        map<char, int> m;
        char temp[512];
        char list[512];
        int list_len = 0;
        int len;
        strcpy(temp, S.c_str());
        len = strlen(temp);
        int max = 0;
        
        for(int i=0;i<len;++i)
        {
            if(m.find(temp[i]) == m.end())
            {
                list[list_len] = temp[i];
                list_len += 1;
                m[temp[i]] = 1;
            }
            else
                m[temp[i]] += 1;
            
            if(m[temp[i]]>max)
                max = m[temp[i]];
        }
        
        if(len%2==0)
        {
            if((max-1)>=(len/2))
                return "";
        }
        else
        {
            if((max-2)>=(len/2))
                return "";
        }
        
        
        typedef struct ListNode {
            char character;
            int num;
            ListNode* next;
        } ListNode;
        
        ListNode* first = NULL;
        for(int i=0;i<list_len;++i)
        {
            ListNode* newNode = (ListNode*)malloc(sizeof(ListNode));
            newNode->next = NULL;
            newNode->num = m[list[i]];
            newNode->character = list[i];
            
            if(first==NULL)
                first = newNode;
            else
            {
                if(first->num < newNode->num)
                {
                    newNode->next = first;
                    first = newNode;
                }
                else
                {
                    ListNode* cur = first;

                    while(1)
                    {
                        if(cur->next==NULL)
                        {
                            cur->next = newNode;
                            break;
                        }
                        else if(cur->next->num < newNode->num)
                        {
                            newNode->next = cur->next;
                            cur->next = newNode;
                            break;
                        }
                        else
                            cur = cur->next;
                    }
                }
            }
        }
        
        string newS = ""; 
        while(1)
        {
            if(first==NULL)
                break;
            
            newS += first->character;
            
            first->num -= 1;
            
            if(first->num==0)
                first = first->next;
            else if(first->next==NULL)
                return "";
            else
            {
                ListNode* temp = first->next;
                ListNode* cur = temp;
                
                while(1)
                {
                    if(cur->next==NULL)
                    {
                        cur->next = first;
                        first->next = NULL;
                        break;
                    }
                    else if(cur->next->num < first->num)
                    {
                        first->next = cur->next;
                        cur->next = first;
                        break;
                    }
                    
                    cur = cur->next;
                }
                
                first = temp;
            }
        }
        
        return newS;
        
    }
};
