
#include<iostream>
using namespace std;


int main()
{
    cout<<"enter number of processes"<<endl;
    int n;
    cin>>n;
    
    int at[n],bt[n],tat[n],ct[n],wt[n],pid[n];
    
    cout<<"enter arrival times of processes"<<endl;
    for(int i=0;i<n;i++)
    {
        cout<< "Process : "<<i<<" ";
       cin>>at[i]; 
       pid[i] = i+1;
    }
    cout<<"Enter batch time of processes"<<endl;
    for(int i=0;i<n;i++)
    {
        cout<<"Process : "<<i<<" ";
        cin>>bt[i];
    }
    int temp ;
    for(int i = 0;i<n;i++)
    {
        for(int j=0;j<i;j++)
        {
             if(at[j]>at[j+1])
             {
                temp = at[j+1];
                at[j+1] = at[j];
                at[j] = temp;
                
                temp = bt[j+1];
                bt[j+1] = bt[j];
                bt[j] = temp;
                
                temp = pid[j+1];
                pid[j+1] = pid[j];
                pid[j] = temp;
             }
        }
    }
    cout<<"Arrival times are : ";
    for(int i=0;i<n;i++)
    {
        cout<<at[i]<<" ";
    }
    
    cout<<"Batch times are : ";
    for(int i=0;i<n;i++)
    {
        cout<<bt[i]<<" ";
    }
    
    for(int i=0;i<n;i++)
    {
        if(i==0)
        {
            ct[i] = at[i] + bt[i]; 
        }
        else
        {
            if(at[i]>ct[i-1])
            {
                ct[i] = at[i] + bt[i];
            }
            else
            {
                ct[i] = ct[i-1] + bt[i];
            }
        }
    }
    
    cout<<"Completion time : ";
    for(int i=0;i<n;i++)
    {
        cout<<ct[i];
    }
    
    float avgtat=0,avgwt=0;
    for(int i=0;i<n;i++)
    {
        tat[i] = ct[i] - at[i];
        cout<<"\nturn around time : "<<tat[i]<<" ";
        avgtat = tat[i] + avgtat;
        wt[i] = tat[i] - bt[i];
        cout<<"\n waiting time : "<<wt[i]<<" ";
        avgwt = avgwt + wt[i]; 
    }
    
    avgwt = avgwt/n;
    avgtat = avgtat/n;
    
    cout<< "Average Waiting time  = "<<avgwt<<endl;
    cout<<"Average Turn-around time  = "<<avgtat<<endl;
    
}

