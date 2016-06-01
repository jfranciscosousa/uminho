function like(reviewID) {
  $.ajax({
    type: "POST",
    url: "/reviews/" + reviewID + "/like",
    success: function(data) {
      addFlashMessage("Nice!", 'success');
      likeUpdate(reviewID);
    },
    error: function(data) {
      console.log(data)
      addFlashMessage("Algo inesperado aconteceu!", 'danger');
    }
  });
}

function dislike(reviewID) {
  $.ajax({
    type: "POST",
    url: "/reviews/" + reviewID + "/dislike",
    success: function(data) {
      addFlashMessage("Nice!", 'success');
      dislikeUpdate(reviewID);
    },
    error: function(data) {
      console.log(data)
      addFlashMessage("Algo inesperado aconteceu!", 'danger');
    }
  });
}

function likeUpdate(reviewID) {
  if ($("#votedUP" + reviewID).text() == "true") {
    return;
  } else if ($("#votedDOWN" + reviewID).text() == "true") {
    votesUP = parseInt($("#votesUP" + reviewID).text()) + 1;
    $("#votesUP" + reviewID).text(votesUP);

    votesDOWN = parseInt($("#votesDOWN" + reviewID).text()) - 1;
    $("#votesDOWN" + reviewID).text(votesDOWN);
  } else {
    votesUP = parseInt($("#votesUP" + reviewID).text()) + 1;
    $("#votesUP" + reviewID).text(votesUP);
  }
  $("#votedUP" + reviewID).text("true");
  $("#votedDOWN" + reviewID).text("false");
}

function dislikeUpdate(reviewID) {
  if ($("#votedUP" + reviewID).text() == "true") {
    votesUP = parseInt($("#votesUP" + reviewID).text()) - 1;
    $("#votesUP" + reviewID).text(votesUP);
    votesDOWN = parseInt($("#votesDOWN" + reviewID).text()) + 1;
    $("#votesDOWN" + reviewID).text(votesDOWN);
  } else if ($("#votedDOWN" + reviewID).text() == "true") {
    return;
  } else {
    votesDOWN = parseInt($("#votesDOWN" + reviewID).text()) + 1;
    $("#votesDOWN" + reviewID).text(votesDOWN);
  }
  $("#votedUP" + reviewID).text("false");
  $("#votedDOWN" + reviewID).text("true");
}

var range = document.getElementById('slider');

noUiSlider.create(range, {
	start: [ 20, 80 ], // Handle start position
	step: 10, // Slider moves in increments of '10'
	margin: 20, // Handles must be more than '20' apart
	connect: true, // Display a colored bar between the handles
	direction: 'rtl', // Put '0' at the bottom of the slider
	orientation: 'vertical', // Orient the slider vertically
	behaviour: 'tap-drag', // Move handle on tap, bar is draggable
	range: { // Slider can select '0' to '100'
		'min': 0,
		'max': 100
	},
	pips: { // Show a scale with the slider
		mode: 'steps',
		density: 2
	}
});
