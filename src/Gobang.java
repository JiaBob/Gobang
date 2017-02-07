import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Gobang {
	public static void main(String[] args){
		UI frame = new UI();
		frame.setSize(1000,700);
		frame.setTitle("Gobang");
		frame.setVisible(true);
		
	}
}
class UI extends JFrame implements MouseMotionListener, MouseListener, ActionListener{
	static int xx=0,n=0,step=0;
	static int[] node=new int[10],sub=new int[2];
	static int[][] a=new int[50][2];
	JButton button1,button2;
	int computer;
	static boolean turn=true,turn1=true,turn2=true,turn3=true,turn4=true,turn5=true,turn6=true,turn7=true,turn8=true,Turn=true;
	JTextArea text,time;
	int x,y;
	int[][] ma= new int[15][15];
	
	public UI(){
		
		setLayout(null);
		Chessboard c= new Chessboard();
		add(c);
		time=new JTextArea(50,70);
		add(time);
		time.setBounds(800, 400, 50, 70);
		text=new JTextArea(10,20);
		c.setBounds(0,0,680,630);
		add(text);
		text.setBounds(0,630,50,50);
		c.addMouseMotionListener(this);
		c.addMouseListener(this);
		
		button1= new JButton("人机对弈");
		button1.addActionListener(this);
		button2= new JButton("玩家对弈");
		button2.addActionListener(this);
		add(button1);
		add(button2);
		button1.setBounds(800,200,100,100);
		button2.setBounds(800,300,100,100);
	}
	public static boolean Judge(int[][] ma){
		//横向判断
		for(int c=0;c<15;c++)
			for(int r=0;r<11;r++){
				if(ma[c][r]==ma[c][r+1]&&ma[c][r+1]==ma[c][r+2]&&ma[c][r+2]==ma[c][r+3]
						&&ma[c][r+3]==ma[c][r+4]
						&&ma[c][r+4]==1||ma[c][r]==ma[c][r+1]
						&&ma[c][r+1]==ma[c][r+2]&&ma[c][r+2]==ma[c][r+3]
						&&ma[c][r+3]==ma[c][r+4]&&ma[c][r+4]==2)
					return true;
					
			}
		//纵向判断
		for(int c=0;c<15;c++)
			for(int r=0;r<11;r++){
				if(ma[r][c]==ma[r+1][c]&&ma[r+1][c]==ma[r+2][c]&&ma[r+2][c]==ma[r+3][c]
						&&ma[r+3][c]==ma[r+4][c]
						&&ma[r+4][c]==1||ma[r][c]==ma[r+1][c]
						&&ma[r+1][c]==ma[r+2][c]&&ma[r+2][c]==ma[r+3][c]
						&&ma[r+3][c]==ma[r+4][c]&&ma[r+4][c]==2)
					return true;
					
				
			}
		//斜向判断(/)
		for(int c=0;c<11;c++)
			for(int r=4;r<15;r++){
				if(ma[c][r]==ma[c+1][r-1]&&ma[c+1][r-1]==ma[c+2][r-2]&&ma[c+2][r-2]==ma[c+3][r-3]
						&&ma[c+3][r-3]==ma[c+4][r-4]
						&&ma[c+4][r-4]==1||ma[c][r]==ma[c+1][r-1]
						&&ma[c+1][r-1]==ma[c+2][r-2]&&ma[c+2][r-2]==ma[c+3][r-3]
						&&ma[c+3][r-3]==ma[c+4][r-4]&&ma[c+4][r-4]==2)
					return true;
					
			
			}
		//斜向判断(\)
		for(int c=0;c<11;c++)
			for(int r=0;r<11;r++){
				if(ma[c][r]==ma[c+1][r+1]&&ma[c+1][r+1]==ma[c+2][r+2]&&ma[c+2][r+2]==ma[c+3][r+3]
						&&ma[c+3][r+3]==ma[c+4][r+4]
						&&ma[c+4][r+4]==1||ma[c][r]==ma[c+1][r+1]
						&&ma[c+1][r+1]==ma[c+2][r+2]&&ma[c+2][r+2]==ma[c+3][r+3]
						&&ma[c+3][r+3]==ma[c+4][r+4]&&ma[c+4][r+4]==2)
					return true;
			
			}
		return false;
	}

	public static int getNum(int[][] a){
		int sum=0;
		for(int c=0;c<a.length;c++)
			for(int r=0;r<a[0].length;r++){
				if(a[c][r]!=0)
					sum++;
			}
		return sum;
	}
	public static int search( int[][] ma,int[][] a){
		int sum=0;
		for(int c=0;c<ma.length-a.length+1;c++)
			for(int r=0;r<ma[0].length-a[0].length+1;r++){
				int m=c;
				int num=0;
				for(int cc=0;cc<a.length;cc++,m++){
					int n=r;
					for(int rr=0;rr<a[0].length;rr++,n++)
						if(a[cc][rr]==0){}
							
						else if (ma[m][n]==a[cc][rr]||(ma[m][n]==0 && a[cc][rr]==3)){
							num++;
						}
						   
						else {
							cc=a.length;
							rr=a[0].length;
						}
				     if(num==getNum(a))
				    	 sum++;
			}
			}
		return sum;		
	}
	public static int[][][] access(int[][] ma,boolean turn){
		boolean co = true;
		int sum=0;
		int[] d=new int[1];
		int[][] bb = new int[15][15];
		
		for(int x=0,y=14,c=0,r=14;r>0||c<=15;){
			int[] a=new int[3];
			int[][] b = new int[6][2];
			int valid=0;
			int n=0;
			for(c=x;r<15&&c<15;r++,c++){
				if(ma[c][r]==0){
					if(co){
						a[0]++;
						if(a[0]==3){
							a[0]=2;
							b[0][0]=b[1][0];
							b[0][1]=b[1][1];
							b[1][0]=r;
							b[1][1]=c;
		                    n=2;//
						}
						else {					
							b[n][0]=r;
							b[n][1]=c;
							if(n==0)
		                    	n=1;
		                    else if(n==1)
		                    	    n=2;
						}
					}
					else{
						b[n][0]=r;
						b[n][1]=c;
	                    if(n==0)
	                    	n=1;
	                    else if(n==1)
	                    	n=2;
	                    else if(n==2)
	                    	n=3;
	                    else if(n==3)
	                    	n=4;
	                    else if(n==4)
	                    	n=5;
						a[2]++;
						if(a[2]==2){
							if(valid==4)
								if(a[1]==0)
									if(a[0]==0){
										if(d[0]==1)
											sum+=200;
										else
											sum-=200;
										bb[b[0][1]][b[0][0]]+=valid*valid;
									}
									else{
										if(d[0]==1)
											sum+=1000;
										else
											sum-=1000;
							            if(a[0]==1){
							                bb[b[0][1]][b[0][0]]+=valid*valid;
							                bb[b[1][1]][b[1][0]]+=valid*valid;
							            }
							            if(a[0]==2){
								            bb[b[1][1]][b[1][0]]+=valid*valid;
								            bb[b[2][1]][b[2][0]]+=valid*valid;
							            }
									}
							  if( valid==3){
								  if(a[1]==0){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid-1;
									  }
									  if(a[0]==1){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid*valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
									  }
									  if(a[0]==2){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
										  bb[b[2][1]][b[2][0]]+=valid*valid;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid;
									  }
									  else{
										  if(d[0]==1)
											  sum+=30;
										  else
											  sum-=30;
										  if(a[0]==1){
											  bb[b[0][1]][b[0][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid;
											  bb[b[1][1]][b[1][0]]+=valid*valid;
										  }
										  if(a[0]==2){
											  bb[b[1][1]][b[1][0]]+=valid;
											  bb[b[3][1]][b[3][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid*valid;
										  }
									  }
								  }
							  }
							  if(valid==2){
								  if(d[0]==1)
									  sum+=5;
								  else
									  sum-=5;
								  if(a[1]==0){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
								 		  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid-1;
										  bb[b[4][1]][b[4][0]]+=valid-1;
									  }
								  }
							  }
							  if(valid==1)
								  if((turn&&d[0]==1)||(!turn&&d[0]==2)){
								     if(a[0]==1)									  
										  bb[b[1][1]][b[1][0]]+=valid;
								     if(a[0]==2){									  
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
								     }
								  }
							valid=0;
							co=true;
							int amount=a[0]+a[1]+a[2];
							a[0]=2;
							a[1]=a[2]=0;
							n=2;
							d[0]=0; 
							   for(int cc=0;cc<amount+1;cc++)
								 for(int rr=0;rr<2;rr++){
											if(cc==0)
											    b[cc][rr]=b[amount-2][rr];
											if(cc==1)
												b[cc][rr]=b[amount-1][rr];
											else
												b[cc][rr]=0;
										}
						}
					}
				}
				if(ma[c][r]==1){
					if(d[0]!=2){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum+=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum+=200;
						    bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=1;
					}
					else{
						d[0]=1;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[1][1]][b[1][0]]+=valid*2;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}

						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
				if(ma[c][r]==2){
					if(d[0]!=1){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum-=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum-=200;
							 bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=2;
					}
					else{
						d[0]=2;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum-=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum-=200;
						    bb[b[1][1]][b[1][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
                      
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
			}
			r=y;
			if(r>0){
				y--;
				r--;
			}
			else
				x++;
		}
		for(int x=0,y=0,c=0,r=0;r<14||c<=15;){
			int[] a=new int[3];
			int[][] b = new int[6][2];
			int valid=0;
			int n=0;
			for(c=x;r>=0&&c<15;r--,c++){
				if(ma[c][r]==0){
					if(co){
						a[0]++;
						if(a[0]==3){
							a[0]=2;
							b[0][0]=b[1][0];
							b[0][1]=b[1][1];
							b[1][0]=r;
							b[1][1]=c;
		                    n=2;//
						}
						else {					
							b[n][0]=r;
							b[n][1]=c;
							if(n==0)
		                    	n=1;
		                    else if(n==1)
		                    	    n=2;
						}
					}
					else{
						b[n][0]=r;
						b[n][1]=c;
						if(n==0)
	                    	n=1;
						else if(n==1)
	                    	n=2;
						else if(n==2)
	                    	n=3;
						else if(n==3)
	                    	n=4;
						else if(n==4)
	                    	n=5;
						a[2]++;
						if(a[2]==2){
							if(valid==4)
								if(a[1]==0)
									if(a[0]==0){
										if(d[0]==1)
											sum+=200;
										else
											sum-=200;
										bb[b[0][1]][b[0][0]]+=valid*valid;
									}
									else{
										if(d[0]==1)
											sum+=1000;
										else
											sum-=1000;
							            if(a[0]==1){
							                bb[b[0][1]][b[0][0]]+=valid*valid;
							                bb[b[1][1]][b[1][0]]+=valid*valid;
							            }
							            if(a[0]==2){
								            bb[b[1][1]][b[1][0]]+=valid*valid;
								            bb[b[2][1]][b[2][0]]+=valid*valid;
							            }
									}
							  if( valid==3){
								  if(a[1]==0){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid-1;
									  }
									  if(a[0]==1){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid*valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
									  }
									  if(a[0]==2){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
										  bb[b[2][1]][b[2][0]]+=valid*valid;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid;
									  }
									  else{
										  if(d[0]==1)
											  sum+=30;
										  else
											  sum-=30;
										  if(a[0]==1){
											  bb[b[0][1]][b[0][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid;
											  bb[b[1][1]][b[1][0]]+=valid*valid;
										  }
										  if(a[0]==2){
											  bb[b[1][1]][b[1][0]]+=valid;
											  bb[b[3][1]][b[3][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid*valid;
										  }
									  }
								  }
							  }
							  if(valid==2){
								  if(d[0]==1)
									  sum+=5;
								  else
									  sum-=5;
								  if(a[1]==0){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
								 		  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid-1;
										  bb[b[4][1]][b[4][0]]+=valid-1;
									  }
								  }
							  }
							  if(valid==1)
								  if((turn&&d[0]==1)||(!turn&&d[0]==2)){
								     if(a[0]==1)									  
										  bb[b[1][1]][b[1][0]]+=valid;
								     if(a[0]==2){									  
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
								     }
								  }
							valid=0;
							co=true;
							int amount=a[0]+a[1]+a[2];
							a[0]=2;
							a[1]=a[2]=0;
							n=2;
							d[0]=0; 
							   for(int cc=0;cc<amount+1;cc++)
								 for(int rr=0;rr<2;rr++){
											if(cc==0)
											    b[cc][rr]=b[amount-2][rr];
											if(cc==1)
												b[cc][rr]=b[amount-1][rr];
											else
												b[cc][rr]=0;
										}
						}
					}
				}
				if(ma[c][r]==1){
					if(d[0]!=2){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum+=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum+=200;
						    bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=1;
					}
					else{
						d[0]=1;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[1][1]][b[1][0]]+=valid*2;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}

						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
				if(ma[c][r]==2){
					if(d[0]!=1){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum-=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum-=200;
							 bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=2;
					}
					else{
						d[0]=2;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum-=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum-=200;
						    bb[b[1][1]][b[1][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
                        
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
			}
			r=y;
			if(r<14){
				y++;
				r++;
			}
			else
				x++;
		}
		
		for(int c=0;c<15;c++){
			int[] a=new int[3];
			int[][] b = new int[6][2];
			int valid=0;
			int n=0;
			for(int r=0;r<15;r++){
				if(ma[c][r]==0){
					if(co){
						a[0]++;
						if(a[0]==3){
							a[0]=2;
							b[0][0]=b[1][0];
							b[0][1]=b[1][1];
							b[1][0]=r;
							b[1][1]=c;
		                    n=2;//
						}
						else {					
							b[n][0]=r;
							b[n][1]=c;
		                    if(n==0)
		                    	n=1;
		                    else if(n==1)
		                    	    n=2;
						}
					}
					else{
						b[n][0]=r;
						b[n][1]=c;
						if(n==0)
	                    	n=1;
						else if(n==1)
	                    	n=2;
						else if(n==2)
	                    	n=3;
						else if(n==3)
	                    	n=4;
						else if(n==4)
	                    	n=5;
						a[2]++;
						if(a[2]==2){
							if(valid==4)
								if(a[1]==0)
									if(a[0]==0){
										if(d[0]==1)
											sum+=200;
										else
											sum-=200;
										bb[b[0][1]][b[0][0]]+=valid*valid;
									}
									else{
										if(d[0]==1)
											sum+=1000;
										else
											sum-=1000;
							            if(a[0]==1){
							                bb[b[0][1]][b[0][0]]+=valid*valid;
							                bb[b[1][1]][b[1][0]]+=valid*valid;
							            }
							            if(a[0]==2){
								            bb[b[1][1]][b[1][0]]+=valid*valid;
								            bb[b[2][1]][b[2][0]]+=valid*valid;
							            }
									}
							  if( valid==3){
								  if(a[1]==0){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid-1;
									  }
									  if(a[0]==1){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid*valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
									  }
									  if(a[0]==2){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
										  bb[b[2][1]][b[2][0]]+=valid*valid;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid;
									  }
									  else{
										  if(d[0]==1)
											  sum+=30;
										  else
											  sum-=30;
										  if(a[0]==1){
											  bb[b[0][1]][b[0][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid;
											  bb[b[1][1]][b[1][0]]+=valid*valid;
										  }
										  if(a[0]==2){
											  bb[b[1][1]][b[1][0]]+=valid;
											  bb[b[3][1]][b[3][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid*valid;
										  }
									  }
								  }
							  }
							  if(valid==2){
								  if(d[0]==1)
									  sum+=5;
								  else
									  sum-=5;
								  if(a[1]==0){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
								 		  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid-1;
										  bb[b[4][1]][b[4][0]]+=valid-1;
									  }
								  }
							  }
							  if(valid==1)
								  if((turn&&d[0]==1)||(!turn&&d[0]==2)){
								     if(a[0]==1)									  
										  bb[b[1][1]][b[1][0]]+=valid;
								     if(a[0]==2){									  
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
								     }
								  }
							valid=0;
							co=true;
							int amount=a[0]+a[1]+a[2];
							a[0]=2;	
							a[1]=a[2]=0;
							n=2;
							d[0]=0; 
							   for(int cc=0;cc<amount+1;cc++)
								 for(int rr=0;rr<2;rr++){
											if(cc==0)
											    b[cc][rr]=b[amount-2][rr];
											if(cc==1)
												b[cc][rr]=b[amount-1][rr];
											else
												b[cc][rr]=0;
										}
						}
					}
				}
				if(ma[c][r]==1){
					if(d[0]!=2){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum+=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum+=200;
						    bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=1;
					}
					else{
						d[0]=1;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[1][1]][b[1][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}

						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
				if(ma[c][r]==2){
					if(d[0]!=1){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum-=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum-=50;
							 bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=2;
					}
					else{
						d[0]=2;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum-=50;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum-=50;
						    bb[b[1][1]][b[1][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
                       
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
								   if(cc==0)
								      b[cc][rr]=b[amount-2][rr];
								}
								else
									b[cc][rr]=0;
							}
					}
				}
			}
		}
		for(int c=0;c<15;c++){
			int[] a=new int[3];
			int[][] b = new int[6][2];
			int valid=0;
			int n=0;
			for(int r=0;r<15;r++){
				if(ma[r][c]==0){
					if(co){
						a[0]++;
						if(a[0]==3){
							a[0]=2;
							b[0][0]=b[1][0];
							b[0][1]=b[1][1];
							b[1][0]=c;
							b[1][1]=r;
		                    n=2;//
						}
						else {					
							b[n][0]=c;
							b[n][1]=r;
							if(n==0)
		                    	n=1;
		                    else if(n==1)
		                    	    n=2;
						}
					}
					else{
						b[n][0]=c;
						b[n][1]=r;
						if(n==0)
	                    	n=1;
						else if(n==1)
	                    	n=2;
						else if(n==2)
	                    	 n=3;
						else if(n==3)
	                    	n=4;
						else if(n==4)
	                    	n=5;
						a[2]++;
						if(a[2]==2){
							if(valid==4)
								if(a[1]==0)
									if(a[0]==0){
										if(d[0]==1)
											sum+=200;
										else
											sum-=200;
										bb[b[0][1]][b[0][0]]+=valid*valid;
									}
									else{
										if(d[0]==1)
											sum+=1000;
										else
											sum-=1000;
							            if(a[0]==1){
							                bb[b[0][1]][b[0][0]]+=valid*valid;
							                bb[b[1][1]][b[1][0]]+=valid*valid;
							            }
							            if(a[0]==2){
								            bb[b[1][1]][b[1][0]]+=valid*valid;
								            bb[b[2][1]][b[2][0]]+=valid*valid;
							            }
									}
							  if( valid==3){
								  if(a[1]==0){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid-1;
									  }
									  if(a[0]==1){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid*valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
									  }
									  if(a[0]==2){
										  if(d[0]==1)
											  sum+=40;
										  else
											  sum-=40;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid*valid;
										  bb[b[2][1]][b[2][0]]+=valid*valid;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==0){
										  if(d[0]==1)
											  sum+=10;
										  else
											  sum-=10;
										  bb[b[0][1]][b[0][0]]+=valid;
										  bb[b[1][1]][b[1][0]]+=valid;
									  }
									  else{
										  if(d[0]==1)
											  sum+=30;
										  else
											  sum-=30;
										  if(a[0]==1){
											  bb[b[0][1]][b[0][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid;
											  bb[b[1][1]][b[1][0]]+=valid*valid;
										  }
										  if(a[0]==2){
											  bb[b[1][1]][b[1][0]]+=valid;
											  bb[b[3][1]][b[3][0]]+=valid;
											  bb[b[2][1]][b[2][0]]+=valid*valid;
										  }
									  }
								  }
							  }
							  if(valid==2){
								  if(d[0]==1)
									  sum+=5;
								  else
									  sum-=5;
								  if(a[1]==0){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
								  }
								  if(a[1]==1){
									  if(a[0]==1){
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
									      bb[b[0][1]][b[0][0]]+=valid-1;
									      bb[b[3][1]][b[3][0]]+=valid-1;
									  }
									  if(a[0]==2){
										  bb[b[1][1]][b[1][0]]+=valid;
								 		  bb[b[2][1]][b[2][0]]+=valid;
										  bb[b[3][1]][b[3][0]]+=valid;
										  bb[b[0][1]][b[0][0]]+=valid-1;
										  bb[b[4][1]][b[4][0]]+=valid-1;
									  }
								  }
							  }
							  if(valid==1)
								  if((turn&&d[0]==1)||(!turn&&d[0]==2)){
								     if(a[0]==1)									  
										  bb[b[1][1]][b[1][0]]+=valid;
								     if(a[0]==2){									  
										  bb[b[1][1]][b[1][0]]+=valid;
										  bb[b[2][1]][b[2][0]]+=valid;
								     }
								  }
							valid=0;
							co=true;
							int amount=a[0]+a[1]+a[2];
							a[0]=2;
							a[1]=a[2]=0;
							n=2;
							d[0]=0; 
							   for(int cc=0;cc<amount+1;cc++)
								 for(int rr=0;rr<2;rr++){
											if(cc==0)
											    b[cc][rr]=b[amount-2][rr];
											if(cc==1)
												b[cc][rr]=b[amount-1][rr];
											else
												b[cc][rr]=0;
										}
						}
					}
				}
				if(ma[r][c]==1){
					if(d[0]!=2){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum+=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum+=200;
						    bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=1;
					}
					else{
						d[0]=1;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum+=200;
						    bb[b[1][1]][b[1][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum+=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}

						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
				if(ma[r][c]==2){
					if(d[0]!=1){
						valid++;
						if(a[2]==1){
							if(a[1]==1)
								n--;
							a[1]=1;
							a[2]=0;
						}
						if(valid>=5){
							sum-=1000;
							a[0]=0;
							co=true;
							valid=0;
						}
						if(valid==4&&a[1]==1){
							sum-=200;
							 bb[b[a[0]][1]][b[a[0]][0]]+=valid*valid;
							a[0]=a[1]=0;
							co=true;
							valid=0;
						}
						else co=false;
						d[0]=2;
					}
					else{
						d[0]=2;
						if(a[0]==1&&valid==4&&a[1]==0){
						    sum-=200;
						    bb[b[0][1]][b[0][0]]+=valid*valid;
						    if(a[2]==1)
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==4&&a[1]==0){
						    sum-=200;
						    bb[b[1][1]][b[1][0]]+=valid*2;
						    if(a[2]==1)
						    	bb[b[2][1]][b[2][0]]+=valid*valid;
						}
						if(a[0]==2&&valid==3&&a[1]==0){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid-1;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[0][1]][b[0][0]]+=valid;
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						if(a[0]==2&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[1][1]][b[1][0]]+=valid-1;
						    bb[b[2][1]][b[2][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid;
							    bb[b[2][1]][b[2][0]]+=valid*valid;
							    bb[b[3][1]][b[3][0]]+=valid;
						    }
						    	
						}
						if(a[0]==1&&valid==3&&a[1]==1){
						    sum-=10;
						    bb[b[0][1]][b[0][0]]+=valid;
						    bb[b[1][1]][b[1][0]]+=valid;
						    if(a[2]==1){
						    	bb[b[1][1]][b[1][0]]+=valid*valid;
						    	bb[b[2][1]][b[2][0]]+=valid;
						    }
						    	
						}
						int amount=a[0]+a[1]+a[2];
						n=a[2];
						a[0]=a[2];
						valid=1;
						a[1]=a[2]=0;
						co=false;
						
                        
						for(int cc=0;cc<amount+1;cc++)
							for(int rr=0;rr<2;rr++){
								if(a[2]==1){
									   if(cc==0)
									      b[cc][rr]=b[amount-2][rr];
									}
									else
										b[cc][rr]=0;
							}
					}
				}
			}
		}
		int[][][] x= new int[16][16][16];
		x[0][0][0]=sum;
//		int max=getMax(bb);
//		if(max>8)
//			for(int c=0;c<15;c++)
//				for(int r=0;r<15;r++)
//					if(!(Math.pow(((int) Math.sqrt(max)), 2)-1<bb[c][r]&&bb[c][r]<=max))
//						bb[c][r]=0;
		x[1]=bb;
		return x;
	}
//	public void print(int[][] a){
//		 for(int c=0;c<50;c++){
//	 		for(int r=0;r<2;r++){
//		 System.out.print(a[c][r]+" ");
//	 		}
//		 System.out.println();
//		 }
//		 System.out.println();
//		}
	public static void print(int[][] a){
		 for(int c=0;c<15;c++){
			for(int r=0;r<15;r++){
		 System.out.print(a[c][r]+" ");
			}
		 System.out.println();
		 }
		 System.out.println();
		}
public static int getMax(int[][] ma ){
	int max=0;
	for(int c=0;c<ma.length;c++)
		for(int r=0;r<ma[c].length;r++)
			if(ma[c][r]>max)
				max=ma[c][r];
	return max;
}
public static int[][] deleteMax(int[][] ma,int max){
	for(int c=0;c<ma.length;c++)
		for(int r=0;r<ma[c].length;r++)
			if(ma[c][r]==max)
				ma[c][r]=0;
	return ma;
}
	public static void AI(int[][]ma, int depth,boolean turn){
		if(depth==8)
			turn8=turn;
		if(depth==7)
			turn7=turn;
		if(depth==6)
			turn6=turn;
		if(depth==5)
			turn5=turn;
		if(depth==4)
		    turn4=turn;//
		if(depth==3)
		    turn3=turn;//
		if(depth==2)
			turn2=turn;//
		if(depth==1)
			turn1=turn;//

		if(depth!=0){
			for(int c=0;c<15;c++)
				for(int r=0;r<15;r++){
					if(depth==8)
						turn=turn8;
					if(depth==7)
						turn=turn7;
					if(depth==6)
						turn=turn6;
					if(depth==5)
						turn=turn5;
					if(depth==4)
						turn=turn4;//
					if(depth==3)
						turn=turn3;//
					if(depth==2)
						turn=turn2;//
					if(depth==1)
						turn=turn1;//
					//恢复每层原turn值
					int[][][] temp=access(ma,turn);
					int[][] ma2=temp[1];
					
					//获取可落子位
					if(ma2[c][r]==getMax(ma2)){
						ma2=deleteMax(ma2,getMax(ma2));
						int[][] ma3=new int[15][15];
						for(int d=0;d<15;d++)
							for(int e=0;e<15;e++)
								ma3[d][e]=ma[d][e];
							
						if(depth==6){
							a[n][0]=r;
							a[n][1]=c;
						}
						//记录顶层可落子位
						if(turn)ma3[c][r]=1;
						else ma3[c][r]=2;
						//模拟落子
						if(turn){
							if(Judge(ma3))
								node[depth]=10000;							
							else 
								if(depth==1){  
								   int mark=temp[0][0][0];
							       if(mark>node[depth])
								      node[depth]=mark;
							}	
							if(node[depth+1]!=0&&node[depth]!=0&&node[depth+1]<=node[depth]){
								c=15;
								Turn=false;
								break;
							}
							turn=false;
						}
						else{
							if(Judge(ma3))
								node[depth]=1000;
							else 
								if(depth==1){  
								   int mark=temp[0][0][0];
							       if(mark>node[depth])
								      node[depth]=mark;
							}	
							if(node[depth+1]!=0&&node[depth]!=0&&node[depth+1]>=node[depth]){
								c=15;
								Turn=false;
								break;//剪枝
						    }
							turn=true;
						}
						//剪枝算法
						AI(ma3,depth-1,turn);
					}//ma2[c][r]==4
				}//for
			        if(depth==5){
			        	if(Turn)
				        xx=n++;
			        	else
				        n++;
			        }
			        //获取结果子位
			        if(Turn)
					node[depth+1]=node[depth];
			        else Turn=true;
					node[depth]=0;
                    //剪枝算法
					if(depth==6){//
						node[depth+1]=0;
						sub[0]=a[xx][0];
						sub[1]=a[xx][1];
						n=0;
						for(int cc=0;cc<50;cc++)
							for(int rr=0;rr<2;rr++)
							    a[cc][rr]=0;
		                xx=0;
		                
					}
					//落子及刷新静态变量
		}//depth!=0
	}
//	@Override
//    public void paint(Graphics g){
//    	
//    }
	public void luozi(int r, int c){
		int x=(r+1)*40;
		int y=(c+1)*40;
		if(turn){
			ma[c][r]=1;
			Graphics g = getGraphics();
			   g.setColor(Color.black);
			   g.fillRoundRect(x-13,y+10,40,40,40,40);
			   turn=false;
		}
		else{
			ma[c][r]=2;
			Graphics g = getGraphics();
			   g.setColor(Color.white);
			   g.fillRoundRect(x-13,y+10,40,40,40,40);
			   turn=true;
		}
		
	}
	
	public void mouseMoved(MouseEvent e){
		x=e.getX();
		y=e.getY();
		text.setText(x+","+y);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x=e.getX();
		int y=e.getY();
		if(computer==2){
		//避免下棋必须点到交叉点，四方向均可有20误差
		if(x%40>20)
			x=(x/40+1)*40;
		else
			x=(x/40)*40;
		if(y%40>20)
			y=(y/40+1)*40;
		else
			y=(y/40)*40;
		//黑白轮流落子
		if(turn){
			if(ma[y/40-1][x/40-1]==0){//有子处不能再下
			   ma[y/40-1][x/40-1]=1;
			   Graphics g = getGraphics();
			   g.setColor(Color.black);
			   g.fillRoundRect(x-13,y+10,40,40,40,40);	//奇怪的坐标？？
			   if(Judge(ma)){
				   JDialog dialog= new JDialog(this,"黑胜");
					dialog.setVisible(true);
					removeMouseListener(this);
			   }
			   turn=false;
			}
			else turn=true;
		}
		else{
			if(ma[y/40-1][x/40-1]==0){
			   ma[y/40-1][x/40-1]=2;
		       Graphics g = getGraphics();
			   g.setColor(Color.white);//必须先设置，否则还是黑色
			   g.fillRoundRect(x-13,y+10,40,40,40,40);   
			   if(Judge(ma)){
				   JDialog dialog= new JDialog(this,"白胜");
					dialog.setVisible(true);
					removeMouseListener(this);
			   }
		       turn=true;
			   }
			else turn=false;
		    }
		}
		if(computer==1){
			ma[7][7]=2;
			Graphics g = getGraphics();
			 g.setColor(Color.white);
			 g.fillRoundRect(320-13,320+10,40,40,40,40);
			if(x%40>20)
				x=(x/40+1)*40;
			else
				x=(x/40)*40;
			if(y%40>20)
				y=(y/40+1)*40;
			else
				y=(y/40)*40;
			if(turn){
				if(ma[y/40-1][x/40-1]==0){//有子处不能再下
					   ma[y/40-1][x/40-1]=1;
//					   Graphics g = getGraphics();
					   g.setColor(Color.black);
					   g.fillRoundRect(x-13,y+10,40,40,40,40);	//奇怪的坐标？？
					 
					   if(Judge(ma)){
						   JDialog dialog= new JDialog(this,"黑胜");
							dialog.setVisible(true);
							removeMouseListener(this);
					   }
					   else{
					        turn=false;
					        step++;
					   if(step==1){//第一步随机选点
						   int[][] choices={{x-40,y-40},{x,y-40},{x+40,y-40},
								            {x-40,y},   {0,0},     {x+40,y},
								            {x-40,y+40},{x,y+40},{x+40,y+40}};
						   Random x1=new Random();
						   int y1=0;
						   while(true){
							   y1=x1.nextInt(9);
							   if(y1!=5)
								   break;
						   }
						   int x2=choices[y1][0]/40-1;
						   int y2=choices[y1][1]/40-1;
					       luozi(x2,y2);
					      
					   }
					   
				
					   else{
						   long start = System.currentTimeMillis();
						    AI(ma,6,turn);
						    long end = System.currentTimeMillis(); 
					    	System.out.println(end-start+" ");
					    	luozi(sub[0],sub[1]);
							    	if(Judge(ma)){
										   JDialog dialog= new JDialog(this,"白胜");
											dialog.setVisible(true);
											removeMouseListener(this);
									   }
							       step++;
							
							       turn=true;
						   
					       }
					   }
				}
				       
					
			}
		}
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1)
			computer=1;
		if(e.getSource()==button2)
			computer=2;
		
	}
}
class AIthread extends UI implements Runnable{
	Thread t;
	AIthread(){
		t = new Thread(this,"AIthread");
		t.start();
	}
	public void run(){	
		long start = System.currentTimeMillis();
	    AI(ma,2,turn);
	    long end = System.currentTimeMillis(); 
    	System.out.println(end-start+" ");
    	luozi(sub[0],sub[1]);
		    	if(Judge(ma)){
					   JDialog dialog= new JDialog(this,"白胜");
						dialog.setVisible(true);
						removeMouseListener(this);
				   }
		       step++;
		
		       turn=true;
		}
}
class Chessboard extends JPanel {
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		for(int y=40;y<=600;y+=40)
			g.drawLine(40, y, 600, y);
		
		for(int x=40; x<=600; x+=40)
		    g.drawLine(x, 40, x, 600 );
		
	}
}

