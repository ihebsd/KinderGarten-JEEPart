

			var daily = $("input[name=hidden_field2],input[name=hidden_field3]");
			var everyweekday = $("input[name=hidden_field1],input[name=hidden_field3]");
			var weekly = $("input[name=hidden_field1],input[name=hidden_field2]");
			$("input[name='hidden_field1']").change(function() {
				daily.prop("disabled", this.checked);
			});

			$("input[name='hidden_field2']").change(function() {
				everyweekday.prop("disabled", this.checked);
			});
			$("input[name='hidden_field3']").change(function() {
				weekly.prop("disabled", this.checked);
			});

