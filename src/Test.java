import java.util.Random;

public class Test {

	public static void main(String[] args) {
		 int[][] a={{0,0,0,0,0,0,0},
		            {0,0,1,0,0,0,0},
		            {0,1,0,0,0,0,0},
		            {0,0,0,0,0,0,0},
		            {0,0,1,0,0,0,0},
		            {0,1,0,0,0,0,0},
		            {0,0,0,0,0,0,0}};

		 int[][] d={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
//		 long start = System.currentTimeMillis(); 
//		 for(int c=0;c<15;c++){
//	    		for(int r=0;r<15;r++){
//		 System.out.print(getPosition(d,true)[c][r]+" ");
//	    		}
//		 System.out.println();
//		 }
//    	 long end = System.currentTimeMillis(); 
//    	System.out.println(end-start+" ");
//	   System.out.println(access(d,true)+" ");
//         int m=(int) Math.sqrt(17);
//         System.out.println(m);
		 long start = System.nanoTime(); 
		 long start1 = System.currentTimeMillis(); 
		 int abc=255;
		 System.out.println(abc);
//		 int x=access(d,false)[0][0][0];
//		 System.out.println(x);
//		 print(access(d,false)[1]);
		 long end = System.nanoTime(); 
		 long end1 = System.currentTimeMillis(); 
	    	System.out.println(end1+" "+start1+" "+(end1-start1)+" ");
	    	System.out.println(end+" "+start+" "+(end-start)+" ");
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
				if(ma[c][r]==max){
					ma[c][r]=0;
					c=ma.length;
		            break;
				}
		return ma;
	}
	public static int random(int[][] a, boolean turn){
		Random r= new Random();
		int i=r.nextInt(200)-100;
		return i;
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
	public static void print(int[][] a){
	 for(int c=0;c<15;c++){
		for(int r=0;r<15;r++){
	 System.out.print(a[c][r]+" ");
		}
	 System.out.println();
	 }
	 System.out.println();
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
		int max=getMax(bb);
		if(max>8)
			for(int c=0;c<15;c++)
				for(int r=0;r<15;r++)
					if(!(Math.pow(((int) Math.sqrt(max)), 2)-1<bb[c][r]&&bb[c][r]<=max))
						bb[c][r]=0;
		x[1]=bb;
		return x;
	}
}




























