class Solution {

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)->a[0]-b[0]);

        int[] roomCount = new int[n];
        long[] roomEndTime = new long[n];

        for(int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];

            boolean roomFound = false;
            long minRoomEndTime = Long.MAX_VALUE;
            int minRoomEndTimeIndex = -1;
            for(int i=0; i<n; i++){
                if(roomEndTime[i] < minRoomEndTime){
                    minRoomEndTime = roomEndTime[i];
                    minRoomEndTimeIndex = i;
                }
                if(roomEndTime[i] <= start){
                    roomEndTime[i] = end;
                    roomCount[i]++;
                    roomFound = true;
                    break;
                }
                
            }

            if(!roomFound){
                roomEndTime[minRoomEndTimeIndex] = roomEndTime[minRoomEndTimeIndex] + (end-start);
                roomCount[minRoomEndTimeIndex]++;
            }

        }


        int roomNo = 101, max = 0;

        for(int i=0; i<n; i++){
            if(roomCount[i] > max){
                roomNo = i;
                max = roomCount[i];
            } else if(roomCount[i] == max){
                roomNo = Math.min(roomNo, i);
            }
        }

        return roomNo;

    }
}