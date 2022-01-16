// Time Complexity: O(n); Space Complexity: O(m); m - number of teams
function tournamentWinner(competitions, results) {
	let currentBestTeam = '';
	let scores = {[currentBestTeam]: 0};
	// console.log('competitions', competitions, '\nresults', results);
	for (let i = 0; i < competitions.length; i++) {
		let winningTeam = '';
		if (results[i] === 0) {
			// result 0 implies away team wins
			winningTeam = competitions[i][1];
		} else {
			// result 1 implies home team wins\
			winningTeam = competitions[i][0];
		}

		updateScores(winningTeam, 3, scores);

		if (scores[winningTeam] > scores[currentBestTeam]) currentBestTeam = winningTeam;
	}
  return currentBestTeam;
}

function updateScores(team, points, scores) {
	if(!(team in scores)) scores[team] = 0;
	
	scores[team] += points;
}

console.log(tournamentWinner(
	[
		["HTML", "C#"],
		["C#", "Python"],
		["Python", "HTML"]
	], 
	[0,0,1]
));
