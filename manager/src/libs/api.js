import env from '../../build/env';

const ajaxUrl = env === 'development' ? 'http://127.0.0.1:8080' : 'http://127.0.0.1:13030';

let api = {
	getBlogList : ajaxUrl + "/ajax/blog/list.json",
	getBlogInfo : ajaxUrl + "/ajax/blog/blog.json",


	getSystemInfo : ajaxUrl + "/ajax/system/getInfo.json",
}

export default api;