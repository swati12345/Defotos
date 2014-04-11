$(document).ready(function() {
		$('#Popup').click(function() {
			var NWin = window.open('fbsetup', '', 'height=400,width=400');
			if (window.focus) {
				NWin.focus();
			}
			return false;
		});
});