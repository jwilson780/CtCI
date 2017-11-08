stack_city=[[],[],[]]

def push_to_col(element,col):
    stack_city[col].append(element)

def pop_from_col(col):
    return stack_city[col].pop()

def triple_array_one():
    '''I know this isn't with a single array. Just wanted to implement it'''
    print("~~solution one~~")
    push_to_col("hi",0)
    push_to_col("there",0)
    push_to_col("steven",0)
    push_to_col("its",0)
    push_to_col("me",0)
    push_to_col("steven",0)
    print(pop_from_col(0))
    push_to_col("the",1)
    push_to_col("world",2)
    print(pop_from_col(0))
    push_to_col("is",0)
    print(pop_from_col(0))
    push_to_col("ending",1)
    push_to_col("yet",2)
    push_to_col("i",0)
    push_to_col("sit",1)
    print(pop_from_col(0))
    push_to_col("and",2)
    push_to_col("program",0)
    print(stack_city[0])
    print(stack_city[1])
    print(stack_city[2])
    print("")
    
class triple_stacker:
    def __init__(self):
        self.stack_sector=[]
        self.sector_height=(0,0,0)
        self.zero_height=0
        self.one_height=0
        self.two_height=0

    def push_to_sector_a(self,element,sector):
        try:
            self.stack_sector[self.sector_height[sector]*3+sector]
        except:
            self.stack_sector=self.stack_sector+[None,None,None]
        self.stack_sector[self.sector_height[sector]*3+sector]=element
        self.sector_height=(self.sector_height[0]+1 if sector==0 else self.sector_height[0],
                         self.sector_height[1]+1 if sector==1 else self.sector_height[1],
                         self.sector_height[2]+1 if sector==2 else self.sector_height[2])

    def pop_from_sector_a(self,sector):
        self.sector_height=(self.sector_height[0]-1 if sector==0 else self.sector_height[0],
                         self.sector_height[1]-1 if sector==1 else self.sector_height[1],
                         self.sector_height[2]-1 if sector==2 else self.sector_height[2])
        temp = self.stack_sector[self.sector_height[sector]*3+sector]
        self.stack_sector[self.sector_height[sector]*3+sector] = None
        return temp       

    def push_to_sector_b(self,element,sector):
        try:
            self.stack_sector[max(max(self.zero_height*3+sector,
                                      self.one_height*3+sector),
                                  self.two_height*3+sector)]
        except:
            self.stack_sector=self.stack_sector+[None,None,None]
        if sector==0:
            self.stack_sector[self.zero_height*3+sector]=element
            self.zero_height=self.zero_height+1
        elif sector==1:
            self.stack_sector[self.one_height*3+sector]=element
            self.one_height=self.one_height+1
        elif sector==2:
            self.stack_sector[self.two_height*3+sector]=element
            self.two_height=self.two_height+1

    def pop_from_sector_b(self,sector):
        temp=None
        if sector==0:
            self.zero_height=self.zero_height-1
            temp = self.stack_sector[self.zero_height*3+sector]
            self.stack_sector[self.zero_height*3+sector]=None
        elif sector==1:
            self.one_height=self.one_height-1
            temp = self.stack_sector[self.one_height*3+sector]
            self.stack_sector[self.one_height*3+sector]=None
        elif sector==2:
            self.two_height=self.two_height-1
            temp = self.stack_sector[self.two_height*3+sector]
            self.stack_sector[self.two_height*3+sector]=None
        return temp

    def print_stack_sector(self,sector):
        print("[",end="")
        for i in range(len(self.stack_sector)):
            if i%3==sector:
                print("'",self.stack_sector[i],"'",end=",")
        print("]")

    def print_whole_stack(self):
        print("[",end="")
        for i in range(len(self.stack_sector)):
            print("'",self.stack_sector[i],"'",end=",")
        print("]")

def triple_array_two():
    '''retrieval O(1) append(1)? append(n)?
    cannot decide because three None elements are added for size increase
    when the 3rd stack fills'''
    print("~~solution two~~")
    ts1=triple_stacker()
    ts1.push_to_sector_a("hi",0)
    ts1.push_to_sector_a("there",0)
    ts1.push_to_sector_a("steven",0)
    ts1.push_to_sector_a("its",0)
    ts1.push_to_sector_a("me",0)
    ts1.push_to_sector_a("steven",0)
    print(ts1.pop_from_sector_a(0))
    ts1.push_to_sector_a("the",1)
    ts1.push_to_sector_a("world",2)
    print(ts1.pop_from_sector_a(0))
    ts1.push_to_sector_a("is",0)
    print(ts1.pop_from_sector_a(0))
    ts1.push_to_sector_a("ending",1)
    ts1.push_to_sector_a("yet",2)
    ts1.push_to_sector_a("i",0)
    ts1.push_to_sector_a("sit",1)
    print(ts1.pop_from_sector_a(0))
    ts1.push_to_sector_a("and",2)
    ts1.push_to_sector_a("program",0)
    ts1.print_stack_sector(0)
    ts1.print_stack_sector(1)
    ts1.print_stack_sector(2)
    print("")
    ts1.print_whole_stack()
    print("")

def triple_array_three():
    '''the only difference between these two is that this uses integer
    height pointers rather than a tuple.'''
    print("~~solution three~~")
    ts2=triple_stacker()
    ts2.push_to_sector_b("hi",0)
    ts2.push_to_sector_b("there",0)
    ts2.push_to_sector_b("steven",0)
    ts2.push_to_sector_b("its",0)
    ts2.push_to_sector_b("me",0)
    ts2.push_to_sector_b("steven",0)
    print(ts2.pop_from_sector_b(0))
    ts2.push_to_sector_b("the",1)
    ts2.push_to_sector_b("world",2)
    print(ts2.pop_from_sector_b(0))
    ts2.push_to_sector_b("is",0)
    print(ts2.pop_from_sector_b(0))
    ts2.push_to_sector_b("ending",1)
    ts2.push_to_sector_b("yet",2)
    ts2.push_to_sector_b("i",0)
    ts2.push_to_sector_b("sit",1)
    print(ts2.pop_from_sector_b(0))
    ts2.push_to_sector_b("and",2)
    ts2.push_to_sector_b("program",0)
    ts2.print_stack_sector(0)
    ts2.print_stack_sector(1)
    ts2.print_stack_sector(2)
    print("")
    ts2.print_whole_stack()
    print("")
        
        
triple_array_one()
triple_array_two()
triple_array_three()
