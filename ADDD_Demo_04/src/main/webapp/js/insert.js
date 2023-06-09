window.addEventListener("load", () => {
	new Vue({
		el: "#excel-data",
		data() {
			return {
				users: [],
				file: null
			}
		},
		mounted() {
			this.fileInputListener();
		},
		methods: {
			fileInputListener() {
				const fileInput = document.getElementById("file-input");
				const fileLabel = document.getElementsByClassName("file-label")[0];
				const inputValue = document.getElementById("users-value");
				const btn = document.getElementById("file-insert-btn");
				const form = document.getElementById("by-file-form");
				// 监听文件变更事件
				fileInput.addEventListener("change", fe => {

					console.log(fe.target.files[0]);

					if (fe.target.files[0] != undefined) {
						const fileReader = new FileReader();

						this.file = fe.target.files[0];

						fileReader.addEventListener("load", ev => {
							try {
								var data = ev.target.result;

								var workbook = XLSX.read(data, {
									type: "binary" // 二进制读取得到excel整份的表格数据
								});
							} catch (err) {
								this.file = null;
								this.users = [];
								fileInput.value = "";
								alert("文件格式不支持，仅支持Excel工作表文件！");
								return;
							}
							var fromTo = "";
							for (var sheet in workbook.Sheets) {
								if (workbook.Sheets.hasOwnProperty(sheet)) {
									fromTo = workbook.Sheets[sheet]["!ref"];
									if (fromTo != undefined) {
										this.users = XLSX.utils.sheet_to_json(workbook.Sheets[sheet]);
									}
								}
							}
						});

						fileReader.readAsBinaryString(this.file);
						
					} else {
						this.file = null;
						this.users = [];
						fileInput.value = "";
					}

				});
				
				// 监听点击事件
				btn.addEventListener("click", () => {
					if(this.file != null && this.users.length > 0){
						var usersString = JSON.stringify(this.users);
						console.log(usersString);
						
						inputValue.value = usersString;
						
						form.submit();
						
					}else {
						alert("操作异常，请稍后重试！");
						return;
					}
				});
			}
		}
	});
});