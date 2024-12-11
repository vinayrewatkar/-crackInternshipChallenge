class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int start = 0, tank = 0;

        // Calculate total gas and cost to determine if a solution exists
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // If total gas is less than total cost, no solution exists
        if (totalGas < totalCost) return -1;

        // Find the starting station
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            // If tank becomes negative, reset the starting station
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
