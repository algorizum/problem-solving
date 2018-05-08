/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if (matrix.length === 0) {
        return false;
    }

    var m = matrix;
    var rows = m.length;
    var columns = m[0].length;
    for (var i = 0; i < rows; i++) {
        if (m[i][0] > target) {
            continue;
        }

        for (var j = 0; j < columns; j++) {
            if (m[i][j] === target) {
                return true;
            }
        }
    }

    return false;
};
