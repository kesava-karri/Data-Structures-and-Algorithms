const fish = ['nemo'];
const allFish = ['dory', 'bruce', 'marlin', 'nemo', 'gill', 'bloat', 'nigel', 'squirt', 'darla', 'hank'];
const arr = new Array(10000).fill('nemo')

function findNemo(array) {
  let t0 = performance.now();
  for (let i=0; i<fish.length; i++) {
    if(array[i] === 'nemo')
      console.log('Found nemo')
  }
  let t1 = performance.now();
  // Subtracting Time at the start from Time after running the loop
  console.log('Time taken to run ' + (t1-t0) + ' milliseconds');
}

findNemo(arr);
