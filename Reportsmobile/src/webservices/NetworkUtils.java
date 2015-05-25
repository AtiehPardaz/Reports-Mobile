package webservices;

import org.apache.http.HttpStatus;

import retrofit.RetrofitError;
import retrofit.client.Response;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.Atieh.reportsmobile.R;

public class NetworkUtils {
	
	Context context;
	
	public NetworkUtils(Context context){
		this.context = context;
	}

	public String handleRetrofitError(RetrofitError retrofitError)
	{
		String body = context.getResources().getString(R.string.LoginErrorMessageGeneric);
		Response response = retrofitError.getResponse();
		int statusCode = response.getStatus();

		// An IOException occurred while communicating to the server,
		// e.g. Timeout, No connection, etc...
		if (retrofitError.getKind().equals(RetrofitError.Kind.NETWORK)) {
			switch (statusCode) {

			case HttpStatus.SC_BAD_REQUEST: // 400: Bad Request
				body = context.getResources().getString(R.string.HttpStatusMessageBadRequest);
				break;
			case HttpStatus.SC_UNAUTHORIZED: // 401
				body = context.getResources().getString(R.string.HttpStatusMessageUnauthorized);
				break;
			case HttpStatus.SC_FORBIDDEN: // 403
				body = context.getResources().getString(R.string.HttpStatusMessageForbidden);
				break;
			case HttpStatus.SC_NOT_FOUND: // 404
				body = context.getResources().getString(R.string.HttpStatusMessageNotFound);
				break;
			case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED: // 407
				body = context.getResources().getString(R.string.HttpStatusMessageProxyAuthenticationRequired);
				break;
			case HttpStatus.SC_REQUEST_TIMEOUT: // 408
				body = context.getResources().getString(R.string.HttpStatusMessageRequestTimeout);
				break;
			case HttpStatus.SC_INTERNAL_SERVER_ERROR: // 500
				body = context.getResources().getString(R.string.HttpStatusMessageInternalServerError);
				break;
			case HttpStatus.SC_NOT_IMPLEMENTED: // 501
				body = context.getResources().getString(R.string.HttpStatusMessageNotImplemented);
				break;
			case HttpStatus.SC_BAD_GATEWAY: // 502
				body = context.getResources().getString(R.string.HttpStatusMessageBadGateway);
				break;
			case HttpStatus.SC_SERVICE_UNAVAILABLE: // 503: Server
													// Unavailable
				body = context.getResources().getString(R.string.HttpStatusMessageServiceUnavailable);
				break;
			case HttpStatus.SC_GATEWAY_TIMEOUT: // 504
				body = context.getResources().getString(R.string.HttpStatusMessageGatewayTimeout);
				break;
			default:
				break;
			}
		}

		// A non-200 HTTP status code was received from the server
		if (retrofitError.getKind().equals(RetrofitError.Kind.HTTP)) {
			body = response.getReason();
		}

		// An exception was thrown while (de)serializing a body
		if (retrofitError.getKind().equals(
				RetrofitError.Kind.CONVERSION)) {
			body = response.getReason();
		}

		// An internal error occurred while attempting to execute a
		// request
		if (retrofitError.getKind().equals(
				RetrofitError.Kind.UNEXPECTED)) {
			body = response.getReason();
		}
		
		return body;
	}
	
	public boolean isNetworkAvailable() {

		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting()) {
			return true;
		} else {
			return false;
		}

	}


}
