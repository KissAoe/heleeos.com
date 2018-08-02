<template>
	<div>
        <Row>
           <Col span="7">
	            <Card :bordered="false">
	            	
	                <p slot="title">
	                	<Row>
	            			<Col span="18">（匿名）读书感</Col>
	            			<Col span="6">2018-07-29 17:04:37</Col>
	            		</Row>
	                </p>
	                <p>内容</p>
	                <p>内容</p>
	                <p>内容</p>
	            </Card>
	        </Col>
	        <Col span="7" offset="1">
	            <Card :bordered="false">
	                <p slot="title">标题</p>
	                <p>内容</p>
	                <p>内容</p>
	                <p>内容</p>
	            </Card>
	        </Col>
	        <Col span="7" offset="1">
	            <Card :bordered="false">
	                <p slot="title">标题</p>
	                <p>内容</p>
	                <p>内容</p>
	                <p>内容</p>
	            </Card>
	        </Col>
        </Row>
    </div>
</template>
<script>
    export default {
        
    }
</script>