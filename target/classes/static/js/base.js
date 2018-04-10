$(document).ready(function() {
	$('.fenxiang').find('a:eq(0)').on('click', function(event) {
		event.preventDefault();
		var c = $(this).attr('data-id');
		console.log(c);
		$('.' + c).show();
		$('.tankuang  .tk_1 a').on('click', function(event) {
			event.preventDefault();
			$('.tankuang,.tankuang_bg').hide();
		});
	});


});